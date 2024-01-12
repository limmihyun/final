<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Start Left menu area -->
    <div class="left-sidebar-pro">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
            	<h1 style="color:#2E64FE; margin-top:15px;">본사 페이지</h1>   
            </div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
                    	<li>
                            <a href="${pageContext.request.contextPath}/headoffice/home">
							   <span class="educate-icon educate-home icon-wrap"></span>
							   <span class="mini-click-non">홈</span>
							</a>                            
                        </li>
                    	<li>
                            <a class="has-arrow" href="#" aria-expanded="false">
                            	<span class="educate-icon educate-professor icon-wrap"></span> 
                            	<span class="mini-click-non">직원</span>
                            </a>
                            <ul class="submenu-angle form-mini-nb-dp" aria-expanded="false">
                                <li><a href="${pageContext.request.contextPath}/headoffice/emp"><span class="mini-sub-pro">직원 목록</span></a></li>
                                <li><a href="${pageContext.request.contextPath}/headoffice/emp/addEmp"><span class="mini-sub-pro">직원 추가</span></a></li>                               
                            </ul>
                        </li>
                         <li>
                            <a class="has-arrow" href="#" aria-expanded="false">
                            	<span class="educate-icon educate-professor icon-wrap"></span> 
                            	<span class="mini-click-non">회원</span>
                            </a>
                            <ul class="submenu-angle form-mini-nb-dp" aria-expanded="false">
                                <li><a href="${pageContext.request.contextPath}/headoffice/customer"><span class="mini-sub-pro">회원 목록</span></a></li>                                
                            </ul>
                        </li>    
                        <li>
                            <a class="has-arrow" href="#" aria-expanded="false">
                            	<span class="educate-icon educate-course icon-wrap"></span> 
                            	<span class="mini-click-non">프로그램</span>
                            </a>
                            <ul class="submenu-angle form-mini-nb-dp" aria-expanded="false">
                                <li><a href="${pageContext.request.contextPath}/headoffice/program"><span class="mini-sub-pro">프로그램 목록</span></a></li>
                                <li><a href="${pageContext.request.contextPath}/headoffice/program/addProgram"><span class="mini-sub-pro">프로그램 추가</span></a></li>                               
                            </ul>                         
                        </li>                                       
                        <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false">
                            	<span class="educate-icon educate-data-table icon-wrap"></span> 
                            	<span class="mini-click-non">발주</span>
                            </a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Peity Charts" href="/headoffice/sportsEquipmentOrder/list"><span class="mini-sub-pro">발주관리</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false">
                            	<span class="educate-icon educate-data-table icon-wrap"></span> 
                            	<span class="mini-click-non">회원권</span>
                            </a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Peity Charts" href="${pageContext.request.contextPath}/headoffice/membershipList"><span class="mini-sub-pro">회원권 목록</span></a></li>
                            </ul>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Peity Charts" href="${pageContext.request.contextPath}/headoffice/addMembership"><span class="mini-sub-pro">회원권 추가</span></a></li>
                            </ul>
                        </li>
						<li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false">
                            	<span class="educate-icon educate-form icon-wrap"></span> 
                            	<span class="mini-click-non">소모품</span>
                            </a>
                            <ul class="submenu-angle form-mini-nb-dp" aria-expanded="false">
                                <li><a title="Basic Form Elements" href="basic-form-element.html"><span class="mini-sub-pro">Bc Form Elements</span></a></li>
                                <li><a title="Advance Form Elements" href="advance-form-element.html"><span class="mini-sub-pro">Ad Form Elements</span></a></li>
                                <li><a title="Password Meter" href="password-meter.html"><span class="mini-sub-pro">Password Meter</span></a></li>
                                <li><a title="Multi Upload" href="multi-upload.html"><span class="mini-sub-pro">Multi Upload</span></a></li>
                                <li><a title="Text Editor" href="tinymc.html"><span class="mini-sub-pro">Text Editor</span></a></li>
                                <li><a title="Dual List Box" href="dual-list-box.html"><span class="mini-sub-pro">Dual List Box</span></a></li>
                            </ul>
                        </li>
						<li>
                            <a class="has-arrow" href="mailbox.html" aria-expanded="false">
                            	<span class="educate-icon educate-interface icon-wrap"></span> 
                            	<span class="mini-click-non">채팅</span>
                            </a>
                            <ul class="submenu-angle interface-mini-nb-dp" aria-expanded="false">
                                <li><a title="Google Map" href="google-map.html"><span class="mini-sub-pro">Google Map</span></a></li>
                                <li><a title="Data Maps" href="data-maps.html"><span class="mini-sub-pro">Data Maps</span></a></li>
                                <li><a title="Pdf Viewer" href="pdf-viewer.html"><span class="mini-sub-pro">Pdf Viewer</span></a></li>
                                <li><a title="X-Editable" href="x-editable.html"><span class="mini-sub-pro">X-Editable</span></a></li>
                                <li><a title="Code Editor" href="code-editor.html"><span class="mini-sub-pro">Code Editor</span></a></li>
                                <li><a title="Tree View" href="tree-view.html"><span class="mini-sub-pro">Tree View</span></a></li>
                                <li><a title="Preloader" href="preloader.html"><span class="mini-sub-pro">Preloader</span></a></li>
                                <li><a title="Images Cropper" href="images-cropper.html"><span class="mini-sub-pro">Images Cropper</span></a></li>
                            </ul>
                        </li>                     
                    </ul>
                </nav>
            </div>
        </nav>
    </div>
    <!-- End Left menu area -->