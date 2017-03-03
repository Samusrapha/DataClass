package br.com.greenowl.dataclass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface QuestionsSpreadsheetWebService {

    @POST("1gzBxj44waVljFFZvfEprmXUqpAXTTwSGx07lrspHzMU/formResponse")
    @FormUrlEncoded
    Call<Void> completeQuestionnaire(
            @Field("entry.2139421313") String name,
            @Field("entry.1470876217") String dataInput,
            @Field("entry.744137940") String tipoAtendimentoInput,
            @Field("entry.21641010") String proximasEtapasInput

    );

}
