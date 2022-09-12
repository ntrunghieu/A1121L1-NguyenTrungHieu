import {FacilityType} from './facility-type';
import {FacilityRentType} from './facility-rent-type';

export interface Facility {
  id?: number;
  name?: string;
  area?: string;
  cost?: string;
  maxPeople?: string;
  standard?: string;
  description?: string;
  poolArea?: string;
  floor?: string;
  facilityType?: FacilityType;
  facilityRentType?: FacilityRentType;
  url?: string;
}
