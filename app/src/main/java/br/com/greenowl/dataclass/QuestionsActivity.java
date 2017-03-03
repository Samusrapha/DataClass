package br.com.greenowl.dataclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class QuestionsActivity extends AppCompatActivity {

    private TextView nameInputField;
    private TextView data;
    private TextView tipoAtendimento;
    private TextView proximasEtapas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/")
            .build();
        final QuestionsSpreadsheetWebService spreadsheetWebService = retrofit.create(QuestionsSpreadsheetWebService.class);

        nameInputField = (TextView) findViewById(R.id.question_name_input);
        data = (TextView) findViewById(R.id.question_date_input);
        tipoAtendimento= (TextView) findViewById(R.id.question_tipoatendimento_input);
        proximasEtapas= (TextView) findViewById(R.id.question_proximaetapa_input);

        findViewById(R.id.questions_submit_button).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nameInput = nameInputField.getText().toString();
                    String dataInput = data.getText().toString();
                    String tipoAtendimentoInput=tipoAtendimento.getText().toString();
                    String proximasEtapasInput=proximasEtapas.getText().toString();

                    Call<Void> completeQuestionnaireCall = spreadsheetWebService.completeQuestionnaire(nameInput, dataInput,tipoAtendimentoInput,proximasEtapasInput);
                    completeQuestionnaireCall.enqueue(callCallback);
                }
            }
        );
    }

    private final Callback<Void> callCallback = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {

                Log.d("XXX", "Submitted. " + response);

        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {

                Log.e("XXX", "Failed", t);
            }



    };
}
