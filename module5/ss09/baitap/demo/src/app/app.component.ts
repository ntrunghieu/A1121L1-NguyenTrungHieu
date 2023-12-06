import { Component } from '@angular/core';
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo';
  url = " ";
  constructor(private toastr: ToastrService) {}

  // defaultBtnActive(even) {
  //   const cancelBtn = document.querySelector('#cancel-btn');
  //   const wrapper = document.querySelector('.wrapper');
  //   const fileName = document.querySelector('.file-name');
  //   const defaultBtn = document.querySelector('#default-btn');
  //   const customtBtn = document.querySelector('#custom-btn');
  //   const img = document.querySelector('img');
  //   function defaultBtnActive() {
  //
  //   }
  //   defaultBtn.addEventListener("change", function () {
  //     const file = this.files[0];
  //     if (file) {
  //       const reader = new FileReader();
  //       reader.onload = function () {
  //         const result = reader.result;
  //         if (typeof result === "string") {
  //           img.src = result;
  //         }
  //         wrapper.classList.add("active")
  //       }
  //       cancelBtn.addEventListener("click", function () {
  //         img.src = "";
  //         wrapper.classList.remove("active")
  //       })
  //       reader.readAsDataURL(file);
  //     }
  //     if (this.value){
  //       let valueStore = this.value;
  //       fileName.textContent = valueStore;
  //     }
  //   })
  // }
  onSelectFile(e) {
    if (e.target.files){
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload=(event: any) => {
        this.url = event.target.result;
      }
    }
    console.log(this.url);
    // this.url = e.target.files[0];
  }

  showSuccess() {
    this.toastr.success('Hello world!', 'Toastr fun!');
  }
}
