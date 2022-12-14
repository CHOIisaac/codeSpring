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
                <h1 class="page-header">Board Read</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Board Read Page
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                            <div class="form-group">
                                <label>Bno</label> <input class="form-control" name='bno' value='<c:out value="${board.bno}"/> ' readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label>Title</label> <input class="form-control" name='bno' value='<c:out value="${board.title}"/> ' readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label>Text area</label>
                                <textarea class="form-control" rows="3" name='content' readonly="readonly"><c:out value="${board.content}"/> </textarea>
                            </div>
                            <div class="form-group">
                                <label>Writer</label> <input class="form-control" name='writer' readonly="readonly" value='<c:out value="${board.writer}"/>'>
                            </div>
                            <button data-oper='modify' class="btn btn-default" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/> '">Modify</button>
                            <button data-oper='list' class="btn btn-info" onclick="location.href='/board/list'">List</button>

                            <form id='operForm' action="/board/modify" method="get">
                                <input type="hidden" id='bno' name='bno' value='<c:out value="${board.bno}"/> '>
                                <input type="hidden" id='pageNum' name='pageNum' value='<c:out value="${cri.pageNum}"/> '>
                                <input type="hidden" id='amount' name='amount' value='<c:out value="${cri.amount}"/> '>
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
        var operForm = $("#operForm");
        $("button[data-oper='modify']").on("click", function (e){
            operForm.attr("action", "/board/modify").submit();
        });
        $("button[data-oper='list']").on("click", function (){
            operForm.find("#bno").remove();
            operForm.attr("action", "/board/list");
            operForm.submit();
        });
    });
</script>

    <%@include file="../includes/footer.jsp"%>

