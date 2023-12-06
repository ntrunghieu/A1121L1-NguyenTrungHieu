import { Component, OnInit } from '@angular/core';
import {IMaterial} from '../../model/material/imaterial';
import {MaterialServiceService} from '../../service/material/material-service.service';

@Component({
  selector: 'app-list-material',
  templateUrl: './list-material.component.html',
  styleUrls: ['./list-material.component.css']
})
export class ListMaterialComponent implements OnInit {
  materialList: IMaterial[];
  materialDelete: IMaterial;
  indexPage: number;
  totalPages: number;
  searchVal: string;
  constructor(private materialService: MaterialServiceService) { }

  ngOnInit(): void {
    this.findAll(0, '');
  }
  findAll(page: number, search: string) {
    this.materialService.getAll(page, search).subscribe(
      next => {
        this.materialList = next.content;
        this.indexPage = next.number;
        this.totalPages = next.totalPages;
      }
    );
  }
  findMaterialDelete(id: number) {
    this.materialDelete = this.materialList.find(m => m.materialId === id); // di tim thang loi~ de xoa
  }

  delete() {
    this.materialService.delete(this.materialDelete.materialId).subscribe(
      next => {
        this.findAll(this.indexPage, '');
      }
    );
  }

  previousPage() {
    if (this.indexPage === 0) { return; }
    this.indexPage--;
    this.findAll(this.indexPage, '');
  }

  nextPage() {
    if (this.indexPage + 1 === this.totalPages) { return; }
    this.indexPage++;
    this.findAll(this.indexPage, '');
  }

  search() {
    this.findAll(0, this.searchVal);
  }
}
