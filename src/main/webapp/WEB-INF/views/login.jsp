<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 12/7/2022
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>

</head>
<body>
<section class="h-screen">
  <div class="px-6 h-full text-gray-800">
    <div
            class="flex xl:justify-center lg:justify-between justify-center items-center flex-wrap h-full g-6"
    >
      <div
              class="grow-0 shrink-1 md:shrink-0 basis-auto xl:w-6/12 lg:w-6/12 md:w-9/12 mb-12 md:mb-0"
      >
        <lottie-player src="https://assets4.lottiefiles.com/packages/lf20_fou1zjyy.json"  background="transparent"  speed="1"  style="width: 100%; height: 100%;"  loop autoplay></lottie-player>
      </div>
      <div class="xl:ml-20 xl:w-5/12 lg:w-5/12 md:w-8/12 mb-12 md:mb-0">
        <form>
          <!-- Email input -->
          <div class="mb-6">
            <input
                    type="text"
                    class="form-control block w-full px-4 py-2 text-md font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                    id="exampleFormControlInput1"
                    placeholder="Email address"
            />
          </div>

          <!-- Password input -->
          <div class="mb-6">
            <input
                    type="password"
                    class="form-control block w-full px-4 py-2 text-md font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                    id="exampleFormControlInput2"
                    placeholder="Password"
            />
          </div>

          <div class="flex justify-between items-center mb-6">
            <div class="form-group form-check">
              <input
                      type="checkbox"
                      class="form-check-input appearance-none h-4 w-4 border border-gray-300 rounded-sm bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer"
                      id="exampleCheck2"
              />
              <label class="form-check-label text-sm inline-block text-gray-800" for="exampleCheck2"
              >Remember me</label
              >
            </div>
            <a href="#!" class="text-gray-800 text-sm" >Forgot password?</a>
          </div>

          <div class="text-center lg:text-left">
            <button
                    type="button"
                    class="inline-block px-7 py-3 bg-[#59a8e9] text-white font-medium text-xs leading-snug uppercase rounded shadow-md hover:bg-[#4681FF] hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out"
            >
              Login
            </button>
            <p class="text-sm font-semibold mt-2 pt-1 mb-0">
              Don't have an account?
              <a
                      href="#!"
                      class="text-red-600 hover:text-red-700 focus:text-red-700 transition duration-200 ease-in-out"
              >Register</a
              >
            </p>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
</body>
</html>
