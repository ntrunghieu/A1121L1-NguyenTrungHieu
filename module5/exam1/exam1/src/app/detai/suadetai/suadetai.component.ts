import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DetaiService} from '../../service/detai.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-suadetai',
  templateUrl: './suadetai.component.html',
  styleUrls: ['./suadetai.component.css']
})
export class SuadetaiComponent implements OnInit {
  suaForm: any;
  id: number;

  constructor(private detaiService: DetaiService,
              private route: Router,
              private activedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activedRouter.snapshot.params.id;
    this.detaiService.findByIdSP(this.id).subscribe(
      (data) => {
        this.suaForm = new FormGroup({
          id: new FormControl(data.id),
          tenSV: new FormControl(data.tenSV, [Validators.required, Validators.pattern(/^[NHÓM 1] |[NHÓM 2] | [NHÓM 3]$/)]),
          tenNhom: new FormControl(data.tenNhom, [Validators.required, Validators.pattern(/^[a-z][A-Z]+$/)]),
          tenDeTai: new FormControl(data.tenDeTai, [Validators.required, Validators.minLength(6)]),
          giaoVien: new FormControl(data.giaoVien, [Validators.required]),
          email: new FormControl(data.email, [Validators.required, Validators.pattern('^[a-z]{2,32}@[def](.com)$')]),
          // tslint:disable-next-line:max-line-length
          sdt: new FormControl(data.sdt, [Validators.required,  Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')])
        });
        // this.cus = data;
        // console.log(this.cus);
      }
    );

    this.suaForm = new FormGroup({
      id: new FormControl(''),
      tenSV: new FormControl('', [Validators.required, Validators.pattern(/^[NHÓM 1] |[NHÓM 2] | [NHÓM 3]$/)]),
      tenNhom: new FormControl('', [Validators.required, Validators.pattern(/^[a-z][A-Z]+$/)]),
      tenDeTai: new FormControl('', [Validators.required, Validators.minLength(6)]),
      giaoVien: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]{2,32}@def(.com)$')]),
      sdt: new FormControl('', [Validators.required,  Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')])
    });
  }

  submit() {
    console.log(this.suaForm.value);
    this.detaiService.updateSP(this.id, this.suaForm.value).subscribe(
      () => {},
      () => {},
      () => {
        this.route.navigateByUrl('');
        alert('Sửa thành công');
      }
    );
  }
  compareObjects(o1: any, o2: any) {
    // if(o1.name == o2.name && o1.id == o2.id )
    //   return true;
    // else return false
    return o1 && o2 ? o1.id === o2.id : o1 = o2;
  }
}
