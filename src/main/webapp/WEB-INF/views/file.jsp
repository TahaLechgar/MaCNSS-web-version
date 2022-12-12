<%--
  Created by IntelliJ IDEA.
  User: Taha Lechgar
  Date: 12/7/2022
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>

    <script src="https://cdn.tailwindcss.com"></script>
    <script defer src="https://unpkg.com/alpinejs@3.x.x/dist/cdn.min.js"></script>

</head>
<body >

<%@ include file="components/navbar.jsp" %>

<main class="w-full h-full pt-4 flex  justify-center">
    <form x-data="tagSelect()" action="<c:url value="/file/add" />" method="post" class="w-8/12 flex flex-col h-full">
        <div class="w-full h-full">
            <div class="shadow sm:rounded-md sm:overflow-hidden">
                <div class="bg-white py-6 px-4 space-y-6 sm:p-6">
                    <div>
                        <h3 class="text-lg leading-6 font-medium text-gray-900">Add medical file</h3>
                        <p class="mt-1 text-sm text-gray-500">Use a permanent address where you can recieve mail.</p>
                    </div>

                    <div  class="grid grid-cols-6 gap-6">
                        <div class="col-span-6">
                            <label for="patient-id" class="block text-sm font-medium text-gray-700">Patient matriculate</label>
                            <input type="text" name="patientMatriculate" id="patient-id" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                        </div>

                        <div class="col-span-3 flex justify-around">
                            <label class="block text-sm font-medium text-gray-700" for="me">For me</label>
                            <input type="radio" @click="isRelative = false" id="me" value="me" name="relative" class="form-check-input appearance-none rounded-full h-4 w-4 border border-gray-300 bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer">
                            <label for="relative" class="block text-sm font-medium text-gray-700">For relative</label>
                            <input type="radio" @click="isRelative = true"  id="relative" value="relative" name="relative" class="form-check-input appearance-none rounded-full h-4 w-4 border border-gray-300 bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer">
                        </div>
                        <div x-show="isRelative" class="col-span-6">
                            <label for="relative-id" class="block text-sm font-medium text-gray-700">Choose a relative :</label>
                            <select id="relative-id" name="relativeId" :disabled="!isRelative" class="mt-1 block w-full bg-white border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                <option selected>Choose</option>
                                <c:forEach items="${relatives}" var="relative">
                                    <option value="${relative.id}">${relative.fullName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-span-6">
                            <label for="consultation" class="block text-sm font-medium text-gray-700">Prescription type : </label>
                            <select id="consultation" name="consultation" class="mt-1 block w-full bg-white border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                <option selected>Choose</option>

                                <c:forEach items="${consultations}" var="consultation">
                                   <option value="${consultation.id}">${consultation.type}</option>
                               </c:forEach>
                            </select>
                        </div>

                        <div class="col-span-6">
                            <label for="attachment-number" class="block text-sm font-medium text-gray-700">Enter number of attachments : </label>
                            <input x-model="attachmentsNumber" type="number"  min="1" max="10" id="attachment-number" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                        </div>

                        <template x-for="item in getAttachments()" >
                            <div class="col-span-6" >
                                <label for="attachment" class="block text-sm font-medium text-gray-700">Join attachment : </label>
                                <select id="attachment" name="consultation" class="attachment mt-1 block w-full bg-white border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                    <option selected >choose</option>
                                    <option value="scanner">Scanner</option>
                                    <option value="analyse">Analyse</option>
                                    <option value="radio">Radio</option>
                                </select>
                            </div>
                        </template>

                        <input type="hidden" name="attachmentsNumber" x-model="allAttachments()">


<%--                        <div class="col-span-6">--%>
<%--                            <label for="deposited_at" class="block text-sm font-medium text-gray-700">Prescription date : </label>--%>
<%--                            <input type="date" id="deposited_at" name="depositedAt" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">--%>
<%--                        </div>--%>
                    </div>
                </div>
            </div>
        </div>
        <br>

        <div class="w-full h-full" >
            <div class="shadow sm:rounded-md sm:overflow-hidden">
                <div class="bg-white py-6 px-4 space-y-6 sm:p-6">
                    <div>
                        <h3 class="text-lg leading-6 font-medium text-gray-900">Join Medications</h3>
                        <p class="mt-1 text-sm text-gray-500">Use a permanent address where you can receive mail.</p>
                    </div>

                    <input x-model="medicament(tags)" type="hidden" name="medicaments" id="medicaments">

                    <div class="grid grid-cols-6 gap-6">
                        <div class="col-span-6">
                            <div x-data @tags-update="console.log('tags updated', $event.detail.tags)" data-tags='[]' class="w-full">
                                <div  x-init="init('parentEl')" @click.away="clearSearch()" @keydown.escape="clearSearch()">
                                    <div class="relative" @keydown.enter.prevent="addTag(textInput)">
                                        <input x-model="textInput" x-ref="textInput" @input="search($event.target.value)" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" placeholder="Enter some tags">

                                        <div :class="[open ? 'block' : 'hidden']">
                                            <div class="absolute z-40 left-0 mt-2 w-full">
                                                <div class="py-1 text-sm bg-white rounded shadow-lg border border-gray-300">
                                                    <a @click.prevent="addTag(textInput)" class="block py-1 px-5 cursor-pointer hover:bg-indigo-600 hover:text-white">Add tag "<span class="font-semibold" x-text="textInput"></span>"</a>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- selections -->
                                        <template x-for="(tag, index) in tags">
                                            <div class="bg-indigo-100 inline-flex items-center text-sm rounded mt-2 mr-1">
                                                <span class="ml-2 mr-1 leading-relaxed truncate max-w-xs" x-text="tag"></span>
                                                <button @click.prevent="removeTag(index)" class="w-6 h-8 inline-block align-middle text-gray-500 hover:text-gray-600 focus:outline-none">
                                                    <svg class="w-6 h-6 fill-current mx-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path fill-rule="evenodd" d="M15.78 14.36a1 1 0 0 1-1.42 1.42l-2.82-2.83-2.83 2.83a1 1 0 1 1-1.42-1.42l2.83-2.82L7.3 8.7a1 1 0 0 1 1.42-1.42l2.83 2.83 2.82-2.83a1 1 0 0 1 1.42 1.42l-2.83 2.83 2.83 2.82z"/></svg>
                                                </button>
                                            </div>
                                        </template>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="px-4 py-3 bg-gray-50 text-right sm:px-6">
                    <button type="submit" class="bg-indigo-600 border border-transparent rounded-md shadow-sm py-2 px-4 inline-flex justify-center text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Save</button>
                </div>
            </div>
        </div>
        <br>


    </form>

</main>

<script>

    function medicament(tags){
        console.log("medicament : ", document.getElementById('medicaments').value);
        return JSON.stringify(tags)
    }

    function allAttachments(){
        let allAttachmentElements = document.getElementsByClassName('attachment');
        let allAttachments = [];

        for (let i = 0; i < allAttachmentElements.length; i++) {
            allAttachments.push(allAttachmentElements[i].value);
        }
        return JSON.stringify(allAttachments)
    }

    function tagSelect() {
        return {
            allAttachments: [],
            isRelative : false,
            attachmentsNumber: 0,
            attachments: ["hehe"],
            open: false,
            textInput: '',
            tags: [],
            init() {
                this.tags = JSON.parse(this.$el.parentNode.getAttribute('data-tags'));
            },
            getAttachments() {
                return Array.from({ length: this.attachmentsNumber});
            },
            addTag(tag) {
                tag = tag.trim()
                if (tag != "" && !this.hasTag(tag)) {
                    this.tags.push( tag )
                }
                this.clearSearch()
                this.$refs.textInput.focus()
                this.fireTagsUpdateEvent()
            },
            fireTagsUpdateEvent() {
                this.$el.dispatchEvent(new CustomEvent('tags-update', {
                    detail: { tags: this.tags },
                    bubbles: true,
                }));
            },
            hasTag(tag) {
                var tag = this.tags.find(e => {
                    return e.toLowerCase() === tag.toLowerCase()
                })
                return tag != undefined
            },
            removeTag(index) {
                this.tags.splice(index, 1)
                this.fireTagsUpdateEvent()
            },
            search(q) {
                if ( q.includes(",") ) {
                    q.split(",").forEach(function(val) {
                        this.addTag(val)
                    }, this)
                }
                this.toggleSearch()
            },
            clearSearch() {
                this.textInput = ''
                this.toggleSearch()
            },
            toggleSearch() {
                this.open = this.textInput != ''
            }
        }
    }
</script>
</body>
</html>
