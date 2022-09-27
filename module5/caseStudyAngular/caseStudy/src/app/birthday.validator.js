import { AbstractControl, ValidationErrors } from '@angular/forms'

// export function birthday(min: Date, max: Date): ValidationErrors | null {
//
//   const v=+control.value;
//
//   if (isNaN(v)) {
//     return { 'gte': true, 'requiredValue': 10 }
//   }
//
//   if (v <= 10) {
//     return { 'gte': true, 'requiredValue': 10 }
//   }
//
//   return null
//
// }

export function dateRangeValidator(min: Date, max: Date): ValidationErrors | null {
  return control => {
    if (!control.value) return null;

    const dateValue = new Date(control.value);

    if (min && dateValue < min) {
      return { 'gte' : true };
    }

    if (max && dateValue > max) {
      return { 'gte' : true };
    }

   return  null;
  }
}
