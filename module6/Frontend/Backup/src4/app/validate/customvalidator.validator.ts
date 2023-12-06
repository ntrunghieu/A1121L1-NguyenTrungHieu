import {AbstractControl, ValidationErrors} from '@angular/forms';
import {formatDate} from "@angular/common";

export function checkAge(control: AbstractControl): ValidationErrors | null {
  const employeeDateOfBirth = control.value;
  const birthday = new Date(employeeDateOfBirth);
  const currentDate = new Date();
  const age = currentDate.getFullYear() - birthday.getFullYear();
  return age > 18 ? null : {invalidAge: true};
}

export function checkHSD(control: AbstractControl): ValidationErrors | null {
  const startDate = control.value.materialExpiridate;

  const dateHSD = formatDate(startDate, 'yyyy-MM-dd', 'en_US');
  const dateCurrent = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');
  return dateHSD >= dateCurrent ? null : {dateError: true};
}
