import { EventInput } from '@fullcalendar/angular';
import { getEffectiveTypeParameterDeclarations, isConstructorDeclaration } from 'typescript';
import { VacationScheduleService } from '../service/vacation-schedule.service';

let eventGuid = 0;
const TODAY_STR = new Date().toISOString().replace(/T.*$/, ''); // YYYY-MM-DD of today

export function createEventId() {
  return String(eventGuid++);
}