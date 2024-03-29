<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
    <table class="board_view">
        <colgroup>
            <col width="15%"/>
            <col width="35%"/>
            <col width="15%"/>
            <col width="35%"/>
        </colgroup>
        <caption>게시글 상세</caption>
        <tbody>
            <tr>
                <th scope="row">글 번호</th>
                <td>${map.title }</td>
                <th scope="row">조회수</th>
                <td>${map.hit_cnt }</td>
            </tr>
            <tr>
                <th scope="row">작성자</th>
                <td>${map.reg_id }</td>
                <th scope="row">작성시간</th>
                <td>${map.reg_dtm }</td>
            </tr>
            <tr>
                <th scope="row">제목</th>
                <td colspan="3">${map.title }</td>
            </tr>
            <tr>
                <td colspan="4">${map.contents }</td>
            </tr>
            <tr>
            	<th scope="row">첨부파일</th>
            	<td colspan="3">
            		<c:choose>
            			<c:when test="${fn:length(list) > 0 }">
		            		<c:forEach items="${list }" var="row">
		            			<p>
		            			<input type="hidden" id="IDX" value="${row.idx }"/>
		            			<a href="#this" id="file">${row.original_file_name }</a>
		            			(${row.file_size }KB)
		            			</p>
		            		</c:forEach>
            			</c:when>
            			<c:otherwise>
							첨부 파일이 없습니다.
            			</c:otherwise>
            		</c:choose>
            	</td>
            </tr>
        </tbody>
    </table>
     
    <a href="#this" class="btn" id="list">목록으로</a>
    <a href="#this" class="btn" id="update">수정하기</a>
     
    <%@ include file="/WEB-INF/include/include-body.jspf" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click", function(e){ //목록으로 버튼
                e.preventDefault();
                fn_openBoardList();
            });
             
            $("#update").on("click", function(e){ //수정하기 버튼
                e.preventDefault();
                fn_openBoardUpdate();
            });
            $("a[id='file']").on("click", function(e){
            	e.preventDefault();
            	fn_downloadFile($(this));
            });
        });
         
        function fn_openBoardList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/board/openBoardList' />");
            comSubmit.submit();
        }
         
        function fn_openBoardUpdate(){
            var idx = "${map.idx}";
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/board/openBoardUpdate' />");
            comSubmit.addParam("IDX", idx);
            comSubmit.submit();
        }
        
        function fn_downloadFile(obj){
        	var idx = obj.parent().find("#IDX").val();
        	var comSubmit = new ComSubmit();
        	comSubmit.setUrl("<c:url value='/common/downloadFile' />");
            
        	/* if(gfn_isNull($("[name='IDX']").val())==false){
        		$("[name='IDX']").remove();
        	} */
        	comSubmit.addParam("IDX", idx);
            comSubmit.submit();
        }
    </script>
</body>
</html>