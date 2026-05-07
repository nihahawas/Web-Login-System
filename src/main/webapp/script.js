// ================= FORM SWITCHING =================
function showSignup() {
    document.getElementById('loginForm').classList.remove('active');
    document.getElementById('signupForm').classList.add('active');
    document.getElementById('forgotForm').classList.remove('active');
}

function showLogin() {
    document.getElementById('loginForm').classList.add('active');
    document.getElementById('signupForm').classList.remove('active');
    document.getElementById('forgotForm').classList.remove('active');
}

function showForgotPassword() {
    document.getElementById('loginForm').classList.remove('active');
    document.getElementById('signupForm').classList.remove('active');
    document.getElementById('forgotForm').classList.add('active');
}


// ================= OPTIONAL VALIDATION =================

// Signup validation (password match)
document.querySelector('#signupForm form').addEventListener('submit', function (e) {
    const password = this.querySelector('input[name="password"]').value;
    const confirmPassword = this.querySelector('input[name="confirmPassword"]').value;

    if (password !== confirmPassword) {
        e.preventDefault(); // block ONLY if error
        alert("Passwords do not match!");
    }
});

// Optional: basic email validation (frontend only)
document.querySelectorAll('input[type="email"]').forEach(input => {
    input.addEventListener('input', function () {
        const valid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.value);
        this.style.borderColor = valid ? "#10b981" : "#ef4444";
    });
});