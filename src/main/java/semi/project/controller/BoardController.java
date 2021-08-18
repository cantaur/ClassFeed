package semi.project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import semi.project.domain.*;
import semi.project.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 스트림페이지 리스트 출력
 * 스트림 공지사항 입력
 * 수업페이지 리스트 출력
 * */

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("myboard")

public class BoardController {
    private TeacherService teacherService;
    private SubjectService subjectService;
    private ClassService classService;
    private BoardService boardService;
    private NoticeService noticeService;
    private StudentService studentService;
    private ThemeService themeService;

    
    
    
    @GetMapping("/content.do") // 과제or자료를 눌렀을때
    public ModelAndView readBoard(String sucode, HttpSession session,long bseq, BoardVo boardVo) {
        Object id1 = session.getAttribute("loginOksid"); // session 에서 sid 값 불러오기
        Object id2 = session.getAttribute("loginOkTid"); // session 에서 tid 값 불러오기
        Object code = session.getAttribute("sucode");
        String sid = (String)id1;
        String tid = (String)id2;
        String gaincode = (String)code;
        log.info("#boadlist sid:"+sid+" seq: "+bseq);


        if(tid != null){

        }else if(sid !=null){
            String writeTid = boardService.boardSelectTidS(bseq); // bseq를 이용해 선생님 아이디 불러옴
            String tname = teacherService.tnameS(tid); // 불러온 tid를 이용해서 선생님 이름 불러옴
            List<BoardVo> list =  boardService.boardSelectBySeqS(bseq);
            log.info(list);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("content/boardCon");
            mv.addObject("list", list);
            mv.addObject("tname",tname);
            return mv;

        }

        return null;
    }






    ArrayList<SubjectVo> sInfo2Header(String sid){ //header.jsp에 학생 정보를 보내기 위한 메소드입니다

        List<String> sucodelist = classService.selectBySidS(sid);
        ArrayList<SubjectVo> t = new ArrayList<SubjectVo>();
        for(int i = 0;i<sucodelist.size();i++) {
            List<SubjectVo> list = subjectService.selectAllS(sucodelist.get(i));
            for(int j=0;j<list.size();j++) {
                t.add(list.get(j));
            }
        }
        return t;
    }
}
