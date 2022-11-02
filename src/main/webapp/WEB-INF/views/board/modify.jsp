<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: choiingyu
  Date: 2022/10/29
  Time: 4:38 오후
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../includes/header.jsp"%>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Board Modify</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Board modify Page
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form role="form" action="/board/modify" method="post">
                            <div class="form-group">
                                <label>Bno</label> <input class="form-control" name='bno' value='<c:out value="${board.bno}"/> ' readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label>Title</label> <input class="form-control" name='bno' value='<c:out value="${board.title}"/> '>
                            </div>
                            <div class="form-group">
                                <label>Text area</label>
                                <textarea class="form-control" rows="3" name='content'><c:out value="${board.content}"/> </textarea>
                            </div>
                            <div class="form-group">
                                <label>Writer</label> <input class="form-control" name='writer' readonly="readonly" value='<c:out value="${board.writer}"/>'>
                            </div>
                            <div class="form-group">
                                <label>RegDate</label> <input class="form-control" name='regDate' readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/> '>
                            </div>
                            <div class="form-group">
                                <label>update Date</label> <input class="form-control" name='updateDate' readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/> '>
                            </div>
                            <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
                            <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
                            <button type="submit" data-oper='list' class="btn btn-info" onclick="location.href='/board/list'">List</button>
                        </form>
                    </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
        </div>
        <!-- /.row -->

<script type="text/javascript">
    $(document).ready(function (){
        var formObj = $("form");
        $('button').on("click", function (){
            e.preventDefault();
            var operation = $(this).data("oper");


        })
    })
</script>

    <%@include file="../includes/footer.jsp"%>
