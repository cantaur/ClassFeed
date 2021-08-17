package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.ClassVo;
import semi.project.domain.StudentVo;
import semi.project.domain.SubjectVo;
import semi.project.domain.TeacherVo;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * 메인화면(==개설한 or 수강중인 클래스 리스트)
 */


@Log4j
@Controller
@RequestMapping("main")
@AllArgsConstructor
public class MainController {

    private SubjectService subjectService;
    private ClassService classService;
    private TeacherService teacherService;
	private StudentService studentService;
    private ThemeService themeService;

    @GetMapping("/list.do")
	public ModelAndView list(HttpSession session) {

		Object id = session.getAttribute("loginOksid");
		Object id2 = session.getAttribute("loginOkTid");
		String tid = (String)id2;
		String sid = (String)id;
		log.info("#loginOksid: "+sid);

		if(tid != null) {
			List<TeacherVo> tlist = teacherService.tNameCkS(tid);
			List<SubjectVo> list = subjectService.selectBytid(tid);
			log.info("#tlist"+tlist);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			mv.addObject("tSubList",list);
			mv.addObject("tList", tlist);
			return mv;
		}else if(sid !=null) {
			List<StudentVo> slist = studentService.sNameCkS(sid);
			List<String> sucode = classService.selectBySidS(sid);

			ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();
			ArrayList<TeacherVo> tname = new ArrayList<TeacherVo>();
			for(int i = 0;i<sucode.size();i++) {
				List<SubjectVo> list = subjectService.selectAllS(sucode.get(i));
				List<TeacherVo> tlist = subjectService.selectTnameS(sucode.get(i));
				for(int j=0;j<list.size();j++) {
					t.add(list.get(j));
					tname.add(tlist.get(j));
				}
			}
			ModelAndView mv = new ModelAndView();
			log.info("tname 확인"+tname);
			mv.setViewName("index");
			mv.addObject("sSubList",t);
			mv.addObject("sList", slist);
			mv.addObject("tName", tname);
			return mv;
		}

		return null;
		/*
		List<String> sucode = classService.selectBySidS(sid);
		ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();

		for(int i = 0;i<sucode.size();i++) {
			List<SubjectVo> list = subjectService.selectAllS(sucode.get(i));
			for(int j=0;j<list.size();j++) {
				System.out.println("#list["+i+"]: "+list.get(j));
				t.add(list.get(j));
			}
		}
		ModelAndView mv = new ModelAndView("test/list","list",t);
		return mv;*/
	}
}
