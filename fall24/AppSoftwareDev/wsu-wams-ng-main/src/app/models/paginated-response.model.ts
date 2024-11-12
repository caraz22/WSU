import {MetaData} from "./meta-data.model";

export interface PaginatedResponse<T> {
  meta: MetaData;
  data: T[];
}
