function loginUser(){

let role =
document.getElementById("role").value;

let email =
document.getElementById("email").value;

let password =
document.getElementById("password").value;

/* Validation */

if(role=="" || email=="" || password==""){

alert("Please fill all fields");

return false;

}

/* Admin Login */

if(role=="admin"){

if(email=="admin@gmail.com" &&
password=="admin123"){

alert("Admin Login Successful");

window.location.href="admin_dashboard.html";

}
else{

alert("Invalid Admin Email or Password");

}

}

/* User Login */

else if(role=="user"){

alert("User Login Successful");

window.location.href="user_home2.html";

}

/* Worker Login */

else if(role=="worker"){

alert("Worker Login Successful");

window.location.href="worker_home2.html";

}

return false;

}
