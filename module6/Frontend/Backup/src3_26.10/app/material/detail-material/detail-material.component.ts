import {Component, OnInit} from '@angular/core';
import {IMaterial} from '../../model/material/imaterial';
import {MaterialServiceService} from '../../service/material/material-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-detail-material',
  templateUrl: './detail-material.component.html',
  styleUrls: ['./detail-material.component.css']
})
export class DetailMaterialComponent implements OnInit {
  materials: IMaterial = {};
  id: number;
  materials2: IMaterial[] = [];
  desArray: string[];
  desArray1: string[];
  desArray2: string[];
  imageArray: string[];



  constructor(private materialService: MaterialServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = Number(paramMap.get('id'));
      this.materialService.findMaterialById(this.id).subscribe(material => {
        this.materials = material;

        // Cat chuoi thong tin chi tiet

        //
        const description = this.materials.materialDescribe;

        this.desArray = description.split('@', (4));

        // let image=this.materials.materialImage;
        // this.imageArray=image.split("@")
        const description1 = this.materials.materialDescribe;

        this.desArray1 = description1.split('@');
        this.desArray2 = this.desArray1.slice(3, 4);
        console.log(this.desArray2);

      }
        ,
        (error) => {
          if (error.status === 404) {
            this.router.navigateByUrl('/error404');
          }
          });
    });

    this.getTopMaterial();

  }

  getTopMaterial() {
    this.materialService.getTopNewMaterial().subscribe(data => {
      this.materials2 = data;
    });
  }


}
