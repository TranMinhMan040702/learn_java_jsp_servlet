<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Đăng nhập</title>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->

                <!-- Icon -->
                <!-- <div class="fadeIn first">
				<img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon"
					alt="User Icon" />
			</div> -->

                <!-- Login Form -->
                <form>
                    <input
                        type="text"
                        id="login"
                        class="fadeIn second"
                        name="login"
                        placeholder="Tên đăng nhập"
                    />
                    <input
                        type="password"
                        id="password"
                        class="fadeIn third"
                        name="login"
                        placeholder="Mật khẩu"
                    />
                    <input type="submit" class="fadeIn fourth" value="Log In" />
                </form>

                <!-- Remind Passowrd -->
                <!--<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>-->
            </div>
        </div>
    </body>
</html>
