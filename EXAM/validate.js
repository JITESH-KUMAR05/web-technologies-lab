function ValidateForm() {
  let userName = document.getElementById("userName").value;
  let Password = document.getElementById("Password").value;
  let PhoneNo = document.getElementById("PhoneNo").value;
  let Email = document.getElementById("Email").value;

  if (userName == "" || Password == "" || PhoneNo == "" || Email == "") {
    alert("All fields are required!");
    return false;
  }
  if (userName.length < 6) {
    alert("Username must be at least 6 characters long.");
    return false;
  }
  if (Password.length < 8) {
    alert("Password must be at least 8 characters long.");
    return false;
  }
  let phonePattern = /^[0-9]{10}$/;
  if (!phonePattern.test(PhoneNo)) {
    alert("Phone number must be 10 digits.");
    return false;
  }
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(Email)) {
    alert("Invalid email format.");
    return false;
  }
  return true;
}
