// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyAF_QeapaYa0SO4Q4RLivzjodBExQ8HsZQ",
  authDomain: "slalom2024-d0918.firebaseapp.com",
  databaseURL: "https://slalom2024-d0918-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "slalom2024-d0918",
  storageBucket: "slalom2024-d0918.firebasestorage.app",
  messagingSenderId: "1014655866177",
  appId: "1:1014655866177:web:a99f6ce99ce1f4c6943dc0"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export default app;