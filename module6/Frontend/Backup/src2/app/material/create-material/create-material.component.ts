import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {IMaterial} from "../../model/material/imaterial";
import {Router} from "@angular/router";
import {MaterialServiceService} from "../../service/material/material-service.service";
import {IMaterialType} from "../../model/material/imaterial-type";
import {ICustomer} from "../../model/customer/icustomer";
import {finalize} from "rxjs/operators";
import {AngularFireStorage} from "@angular/fire/storage";

@Component({
  selector: 'app-create-material',
  templateUrl: './create-material.component.html',
  styleUrls: ['./create-material.component.css']
})
export class CreateMaterialComponent implements OnInit {
  materialForm: FormGroup;
  listDataCus:ICustomer[] =[];
  listDataType: IMaterialType[] =[];
  upLoadImage= null;
  oldAvatarLink: string;
  url:any;
  constructor(
    private materialService: MaterialServiceService,
    private router: Router,
    private storage: AngularFireStorage
  ) { }

  ngOnInit(): void {
    this.getListCus();
    this.getListType();
    this.materialForm = new FormGroup({
      materialCode: new FormControl('', [Validators.required, Validators.pattern('MVT-\\d{3}')]),
      materialName: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(25)]),
      materialPrice: new FormControl('', [Validators.required, Validators.min(1)]),
      materialQuantity: new FormControl('', [Validators.required, Validators.min(1)]),
      materialExpiridate: new FormControl('', [Validators.required]),
      materialDescribe: new FormControl('', [Validators.required]),
      materialUnit: new FormControl('', [Validators.required]),
      materialTypeId: new FormControl('', [Validators.required]),
      materialCustomerId: new FormControl('', [Validators.required]),
      materialImage:  new FormControl('', [Validators.required])
    });
  }

  getListType(){
    this.materialService.getListTypeMaterial().subscribe((res: IMaterialType[])=> {
      console.log(res)
      this.listDataType = res;
    })
  }

  getListCus(){
    this.materialService.getListCustomer().subscribe((response: ICustomer[]) =>{
      this.listDataCus = response;
        console.log(this.listDataCus);

    })
  }


createMaterial() {
  if(this.upLoadImage !== null){
    const avatarName = this.getCurrentDateTime() + this.upLoadImage.name;
    const fileRef = this.storage.ref(avatarName);
    this.storage.upload(avatarName, this.upLoadImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe(url => {
          this.materialForm.patchValue({materialImage: url});

          // //delete old img from firebase
          // this.storage.storage.refFromURL(this.oldAvatarLink).delete();

          //Update employee
          console.log(this.materialForm.value);
          this.materialService.create(this.materialForm.value).subscribe(
            () => {
            },
            (error) => {
              if (error.status === 500) {
                this.router.navigateByUrl('/auth/access-denied');
              }
            },
            () => {
              alert("thêm mới vật tư")
              this.upLoadImage = null;
            },
          )
        })
      })
    ).subscribe();
  } else{
    console.log(this.materialForm.value)
    this.materialService.create(this.materialForm.value).subscribe(
      () => {
      },
      (error) => {
        if (error.status === 500) {
          this.router.navigateByUrl('/auth/access-denied');
        }
      },
      () => {
        alert("thêm mới vật tư")
      }
    );
  }
}
  private getCurrentDateTime() {
    return new Date().getTime();
  }

  showPreview(e) {
    this.upLoadImage = e.target.files[0];
    if (e.target.files) {
      const reader = new FileReader();
      reader.readAsDataURL(this.upLoadImage);
      reader.onload = (event: any) => {
        this.url = event.target.result;
      };
    }
  }

  // showPreview(event: any) {
  //   this.upLoadImage = event.target.files[0];
  //
  // }
}
