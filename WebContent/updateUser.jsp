<%@page import="model.User"%>
<%@page import="model.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Sign Up #2</title>
  </head>
  <body>
  
<%
String id=request.getParameter("i");

User u=new UserDao().getUser(id);

if(u!=null)
{

%>
  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7 py-5">
            <h3>Register</h3>
            <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p>
            <form action="update" method="post">
              <div class="row">
              <input type="hidden" name="uid" value="<%=u.getUid() %>" />
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="fname">First Name</label>
                    <input type="text" name="fname" class="form-control" value="<%=u.getFname() %>" placeholder="e.g. John" id="fname">
                  </div>    
                </div>
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="lname">Last Name</label>
                    <input type="text" name="lname" class="form-control" value="<%=u.getLname() %>" placeholder="e.g. Smith" id="lname">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group first">
                    <label for="email">Email Address</label>
                    <input type="email" name="email" class="form-control" value="<%=u.getEmail() %>" placeholder="e.g. john@your-domain.com" id="email">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="lname">Phone Number</label>
                    <input type="text" name="mob" class="form-control" value="<%=u.getMob() %>" placeholder="+00 0000 000 0000" id="lname">
                  </div>    
                </div>
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="lname">Website</label>
                    <input type="text" name="web" class="form-control" value="<%=u.getWeb() %>" placeholder="e.g. https://google.com" id="lname">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
              
                  <div class="form-group last mb-3">
                    <label for="password">Password</label>
                    <input type="password" name="pass" class="form-control" value="<%=u.getPass() %>"placeholder="Your Password" id="password">
                  </div>
                </div>
                <div class="col-md-6">
              
                  <div class="form-group last mb-3">
                    <label for="re-password">Re-type Password</label>
                    <input type="password" class="form-control" value="<%=u.getPass() %>" placeholder="Your Password" id="re-password">
                  </div>
                </div>
              </div>
              
              <div class="d-flex mb-5 mt-4 align-items-center">
                <div class="d-flex align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Creating an account means you're okay with our <a href="#">Terms and Conditions</a> and our <a href="#">Privacy Policy</a>.</span>
                 
                  <input type="checkbox" name="term" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
              </div>
              </div>

              <input type="submit" value="Update" class="btn px-5 btn-primary">

            </form>
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    <%
    }
    
    %>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>