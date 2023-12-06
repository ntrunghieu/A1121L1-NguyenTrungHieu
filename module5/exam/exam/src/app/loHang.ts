import {SanPham} from "./sanPham";

export interface LoHang {
  id:number;
  maLoHang: string;
  sanPham: SanPham;
  soLuong: number;
  ngayNhap: string;
  ngaySX: string;
  ngayHetHan: string;
}
