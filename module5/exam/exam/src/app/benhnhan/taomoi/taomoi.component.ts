import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {BenhnhanService} from "../../service/benhnhan.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-taomoi',
  templateUrl: './taomoi.component.html',
  styleUrls: ['./taomoi.component.css']
})
export class TaomoiComponent implements OnInit {
  taoForm: FormGroup;

  constructor(private benhnhanService: BenhnhanService,
              private route: Router) { }

  ngOnInit(): void {
    this.taoForm = new FormGroup({
      id: new FormControl(''),
      maBA: new FormControl('',[Validators.required, Validators.pattern(/^[B]{1}[A]{1}[-]{1}[0-9]{3}$/)]),
      maBN: new FormControl('',[Validators.required, Validators.pattern(/^[B]{1}[N]{1}[-]{1}[0-9]{3}$/)]),
      ten: new FormControl('',[Validators.required, Validators.minLength(6)]),
      ngayNhap: new FormControl('', [Validators.required, this.dateValidator()] ),
      ngayRa: new FormControl('',[Validators.required]),
      phuongPhap: new FormControl('',[Validators.required]),
      bacSi: new FormControl('',[Validators.required]),
      lyDo: new FormControl('',[Validators.required])
    },);
  }

  dateValidator(): ValidatorFn {
    return (control: AbstractControl): {[key: string]: any} | null => {
      const today = new Date().getTime();

      if(!(control && control.value)) {
        // if there's no control or no value, that's ok
        return null;
      }

      // return null if there's no errors
      return control.value.getTime() > today
        ? {invalid: true }
        : null;
    }
  }
  get ngayNhap() {
    return this.taoForm.get('ngayNhap');
  }

  // get numVal() {
  //   return this.myForm.get('numVal');
  // }

  submit() {
    this.benhnhanService.createBenhNhan(this.taoForm.value).subscribe(data => {
      console.log(data);

    }, (err) => {
      console.log(err);
    },
      () => {
        alert('Thêm mới bệnh nhân thành công');
        this.route.navigateByUrl('');
      });
  }
}
