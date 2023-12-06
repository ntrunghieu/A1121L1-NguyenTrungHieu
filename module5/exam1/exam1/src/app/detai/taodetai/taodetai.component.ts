import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DetaiService} from '../../service/detai.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-taodetai',
  templateUrl: './taodetai.component.html',
  styleUrls: ['./taodetai.component.css']
})
export class TaodetaiComponent implements OnInit {
  taoForm: FormGroup;

  constructor(private detaiService: DetaiService,
              private route: Router) { }

  ngOnInit(): void {
    this.taoForm = new FormGroup({
      id: new FormControl(''),
      tenSV: new FormControl('', [Validators.required, Validators.pattern(/^[a-z][A-Z]{2,32}$/)]),
      tenNhom: new FormControl('', [Validators.required, Validators.pattern(/^[NHÓM 1] |[NHÓM 2] | [NHÓM 3]$/)]),
      tenDeTai: new FormControl('', [Validators.required, Validators.minLength(6)]),
      giaoVien: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z]{2,32}@def(.com)$/)]),
      sdt: new FormControl('', [Validators.required,  Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')])
    });
  }

  submit() {
    this.detaiService.createSP(this.taoForm.value).subscribe(data => {
        console.log(data);

      }, (err) => {
        console.log(err);
      },
      () => {
        alert('Thêm mới đề tài thành công');
        this.route.navigateByUrl('');
      });
  }
}
