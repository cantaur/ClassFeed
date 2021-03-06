package semi.project.mapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import semi.project.domain.BoardVo;


import java.util.List;

@Repository
public interface BoardMapper {
    List<BoardVo> selectBoardBySucode(String sucode);
    BoardVo selectBoardBySeq(long bseq);





















    void insertNotFile(BoardVo boardVo);
    void insertOkFile(BoardVo boardVo);
    void insertBoardOkFile(BoardVo boardVo);
    void insertBoardNotFile(BoardVo boardVo);

    List<BoardVo> boardSelectAll(@Param("tid") String tid, @Param("sucode") String sucode);
    List<BoardVo> boardSelectClass(String sucode);
    String boardSelectTid(long bseq);

    List<BoardVo> selectBySucode(String sucode);
    List<BoardVo> boardSelectBySeq(long bseq);

    void deleteBySeq(long bseq);

    BoardVo getBoard(long bseq);

    void boardUpdate(BoardVo boardVo);
}
