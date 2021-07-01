import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class DateService {
    constructor(){}

    getDayNow(): Date{
        return new Date();
    }
    convertToString(date: Date): string{
        const monthLong = date.toLocaleString('default', { month: 'long' });

        return monthLong + ' ' + date.getDate() + ' ,' + date.getFullYear();
    }
}
