import { Moment } from 'moment';

export interface IProject {
  id?: number;
  name?: string;
  description?: string;
  date?: Moment;
}

export class Project implements IProject {
  constructor(public id?: number, public name?: string, public description?: string, public date?: Moment) {}
}
