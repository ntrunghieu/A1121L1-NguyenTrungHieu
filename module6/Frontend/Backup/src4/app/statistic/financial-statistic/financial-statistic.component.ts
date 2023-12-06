import {Component, OnInit} from '@angular/core';
import {StatisticServiceService} from '../../service/statistic/statistic-service.service';
import {Chart} from 'chart.js';

@Component({
    selector: 'app-financial-statistic',
    templateUrl: './financial-statistic.component.html',
    styleUrls: ['./financial-statistic.component.css']
})
export class FinancialStatisticComponent implements OnInit {
    // KimPBH -Thong ke tai chinh
    ban: any;
    tra: any;
    huy: any;
    nhap: any;
    tongthu = 0;
    tongchi = 0;
    doanhthu = 0;
    search1: string[] = [];
    month = '';
    year = '';

    chart: Chart;
    labels: any;

    constructor(private statisticService: StatisticServiceService) {
    }

    ngOnInit(): void {
        // @ts-ignore
        this.search(undefined);
    }

    exportPDF(): void {
        console.log(this.search1);
        this.statisticService.getPdfKim(this.search1).subscribe(x => {
            const blob = new Blob([x], {type: 'application/pdf'});
            if (window.navigator && window.navigator.msSaveOrOpenBlob) {
                window.navigator.msSaveOrOpenBlob(blob);
                return;
            }
            const data1 = window.URL.createObjectURL(blob);
            const link = document.createElement('a');
            link.href = data1;
            link.download = 'financial-statistic.pdf';
            link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));
            // tslint:disable-next-line:only-arrow-functions
            setTimeout(function () {
                window.URL.revokeObjectURL(data1);
                link.remove();
            }, 100);
        });
    }

    search(value) {
        if (value === undefined) {
            this.month = '';
            this.year = '';
            this.statisticService.search(this.month, this.year).subscribe((data: string[]) => {
                this.search1 = data;
                // tslint:disable-next-line:radix
                this.ban = parseInt(this.search1[0]);
                // tslint:disable-next-line:radix
                this.nhap = parseInt(this.search1[1]);
                // tslint:disable-next-line:radix
                this.huy = parseInt(this.search1[2]);
                // tslint:disable-next-line:radix
                this.tra = parseInt(this.search1[3]);
                this.tongthu = 0;
                this.tongthu = this.ban + this.huy + this.tra;
                this.tongchi = this.nhap;
                this.doanhthu = this.tongthu - this.tongchi;
            });
        } else {
            // tslint:disable-next-line:radix
            if (value.value <= 12) {
                this.month = value.value;
            } else {
                this.year = value.value;
            }
            if (this.month === undefined) {
                this.month = '';
            }
            if (this.year === undefined) {
                this.year = '';
            }
            console.log(this.month);
            console.log(this.year);
            this.statisticService.search(this.month, this.year).subscribe((data: string[]) => {
                this.search1 = data;
                // tslint:disable-next-line:radix
                this.ban = parseInt(this.search1[0]);
                // tslint:disable-next-line:radix
                this.nhap = parseInt(this.search1[1]);
                // tslint:disable-next-line:radix
                this.huy = parseInt(this.search1[2]);
                // tslint:disable-next-line:radix
                this.tra = parseInt(this.search1[3]);
                this.tongthu = 0;
                this.tongthu = this.ban + this.huy + this.tra;
                this.tongchi = this.nhap;
                this.doanhthu = this.tongthu - this.tongchi;
            });
        }
    }

    // test chart financial
    chartFinancial() {
        this.month = '';
        this.year = '';
        this.statisticService.cryptoDataKim().then((data) => {
                console.log(this.ban);
                this.chart = new Chart('canvas', {
                    type: 'bar',
                    data: {
                        labels: this.labels,
                        datasets: [
                            {
                                label: 'Bán hàng',
                                data: [this.ban],
                                borderWidth: 3,
                                fill: false,
                                backgroundColor: 'rgba(93, 175, 89, 0.1)',
                                borderColor: 'yellow'
                            },
                            {
                                label: 'Hủy hàng',
                                data: [this.huy],
                                borderWidth: 3,
                                fill: false,
                                backgroundColor: 'rgba(93, 175, 89, 0.1)',
                                borderColor: 'red'
                            },
                            {
                                label: 'Nhập hàng',
                                data: [this.nhap],
                                borderWidth: 3,
                                fill: false,
                                backgroundColor: 'rgba(93, 175, 89, 0.1)',
                                borderColor: 'blue'
                            },
                            {
                                label: 'Trả hàng',
                                data: [this.tra],
                                borderWidth: 3,
                                fill: false,
                                backgroundColor: 'rgba(93, 175, 89, 0.1)',
                                borderColor: 'dark'
                            },
                        ]
                    },
                });
            }
        );
    }
}
