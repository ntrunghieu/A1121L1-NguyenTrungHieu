import {AbstractControl, ValidationErrors} from '@angular/forms';

export function checkAge(control: AbstractControl): ValidationErrors | null {
  const employeeDateOfBirth = control.value;
  const birthday = new Date(employeeDateOfBirth);
  const currentDate = new Date();
  const age = currentDate.getFullYear() - birthday.getFullYear();
  return age > 18 ? null : {invalidAge: true};
}
