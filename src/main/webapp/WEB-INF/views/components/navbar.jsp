<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 12/7/2022
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header class="bg-white">
    <nav class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8" aria-label="Top">
        <div class="w-full py-6 flex items-center justify-between border-b border-indigo-500 lg:border-none">
            <div class="flex items-center">
                <a href="#">
                    <span class="sr-only">Workflow</span>
                    <img class="h-10 w-auto" src="<c:url value='/images/cnss-removebg-preview.png' /> " alt="">
                </a>
                <div class="hidden ml-10 space-x-8 lg:block">
                    <a href="#" class="text-base font-medium text-[#59a8e9] hover:text-indigo-50"> Solutions </a>

                    <a href="#" class="text-base font-medium text-[#59a8e9] hover:text-indigo-50"> Pricing </a>

                    <a href="#" class="text-base font-medium text-[#59a8e9] hover:text-indigo-50"> Docs </a>

                    <a href="#" class="text-base font-medium text-[#59a8e9] hover:text-indigo-50"> Company </a>
                </div>
            </div>
            <div class="ml-10 space-x-4">
                <a href="#" class="inline-block bg-[#86bfee] py-2 px-4 border border-transparent rounded-md text-base font-medium text-white hover:bg-opacity-75">Sign in</a>
                <a href="#" class="inline-block bg-white py-2 px-4 border border-transparent rounded-md text-base font-medium text-[#86bfee] hover:text-white hover:bg-[#86bfee]">Sign up</a>
            </div>
        </div>
        <div class="py-4 flex flex-wrap justify-center space-x-6 lg:hidden">
            <a href="#" class="text-base font-medium text-white hover:text-indigo-50"> Solutions </a>

            <a href="#" class="text-base font-medium text-white hover:text-indigo-50"> Pricing </a>

            <a href="#" class="text-base font-medium text-white hover:text-indigo-50"> Docs </a>

            <a href="#" class="text-base font-medium text-white hover:text-indigo-50"> Company </a>
        </div>
    </nav>
</header>
