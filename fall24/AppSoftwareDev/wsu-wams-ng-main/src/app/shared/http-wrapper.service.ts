import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable, signal } from "@angular/core";

@Injectable({
  providedIn: 'root',
})
export class HttpWrapperService {

  constructor(private _http: HttpClient) {
  }

  status = signal<string>(''); // initialize a signal for updating http status across application
  message = signal<string>(''); // initialize a signal for updating a message to be displayed according to http call state

  doPost(url: string, payload: any): Observable<any> { // do a post request and return an observable with data from post req
    return new Observable<any>(observer => {
      this._http.post(url, payload).subscribe(res =>{
        // process call universally here
        observer.next(res); // return
      });
    });
  }

  doPut(url: string, payload: any): Observable<any> {
    return new Observable<any>(observer => {
      this._http.put(url, payload).subscribe(res =>{
        // process call universally here
        observer.next(res); // return
      });
    });
  }

  doGet(url: string, payload: any) {
    return new Observable<any>(observer => {
      this._http.get(url).subscribe(res =>{
        // process call universally here
        observer.next(res); // return
      });
    });
  }

  doDelete(url: string): Observable<any> {
    return new Observable<any>(observer => {
      this._http.delete(url).subscribe({
        next: res => {
          // process call universally here
          observer.next(res); // return
        },
        error: err => {
          // handle error universally here
          observer.error(err); // propagate error
        },
        complete: () => {
          // handle completion universally here
          observer.complete(); // signal completion
        }
      });
    });
  }
}
