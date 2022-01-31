import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable, Output} from '@angular/core';
import { Observable } from 'rxjs';
import { Business, Quotes, Supplier } from 'src/app/models/Supplier';
import { UrlMappings } from 'src/app/shared/UrlMappings';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupplierServiceService {


  constructor(public httpClient : HttpClient) { }

  getSupplierBySessionId() : Observable<any>{
    return this.httpClient.get(environment.baseUrl + UrlMappings.getLoggedInSupplier + "/" + localStorage.getItem('sessionId'));
  }

  updatePersonalDetail(supplier :  Supplier){
    return this.httpClient.put(environment.baseUrl + UrlMappings.updateSupplier, supplier, {headers : new HttpHeaders().set('sessionId', localStorage.getItem('sessionId'))})
  }

  updateBusinessDetail(business : Business) : Observable<any>{
    return this.httpClient.post(environment.baseUrl + UrlMappings.updateBusiness, business, {headers : new HttpHeaders().set('sessionId', localStorage.getItem('sessionId'))})
  }

  getQuotesBySessionId() : Observable<any> {
    return this.httpClient.get(environment.baseUrl + UrlMappings.getQuotesBySessionId + localStorage.getItem('sessionId'))
  }

  getSupplierByBusinessId(businessId : String){
    return this.httpClient.get(environment.baseUrl + UrlMappings.getSupplierByBusinessId + businessId)
  }

  newQuotes(quotes :  Quotes){
    return this.httpClient.post(environment.baseUrl + UrlMappings.newQuote , quotes)
  }

  getSupplierOrder(){
    return this.httpClient.get(environment.baseUrl + UrlMappings.getSupplierOrder , {headers : new HttpHeaders().set('sessionId', localStorage.getItem('sessionId'))})
  }

  changeDeliveryStatus(orderId : string, deliveryStatus : string){
    return this.httpClient.post(environment.baseUrl + UrlMappings.changeOrderStatus , {id : orderId, deliveryStatus : deliveryStatus})
  }

  getSupplierOrderHistory(){
    return this.httpClient.get(environment.baseUrl + UrlMappings.getSupplierOrderHistory , {headers : new HttpHeaders().set('sessionId', localStorage.getItem('sessionId'))})
  }

}