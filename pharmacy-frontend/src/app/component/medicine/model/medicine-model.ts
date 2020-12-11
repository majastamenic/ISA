import { Observable } from 'rxjs';

export interface Medicine{
    code: number;
    name: string;
    type: string;
    form: string;
    manufactured: string;
    publishingType: string;
    node: string;
}
