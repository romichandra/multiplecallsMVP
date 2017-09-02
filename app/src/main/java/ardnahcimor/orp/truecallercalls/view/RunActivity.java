package ardnahcimor.orp.truecallercalls.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import ardnahcimor.orp.truecallercalls.R;
import ardnahcimor.orp.truecallercalls.model.model10th;
import ardnahcimor.orp.truecallercalls.model.modelEvery10th;
import ardnahcimor.orp.truecallercalls.model.modelWordCount;
import ardnahcimor.orp.truecallercalls.network.Service;
import ardnahcimor.orp.truecallercalls.presenter.RunPresenter;
import ardnahcimor.orp.truecallercalls.view.BaseActivity;

public class RunActivity extends BaseActivity implements IActivity{

    @Inject
    public Service mService;

    private RunPresenter runPresenter;

    private TextView text10thChar, textEvery10thChar, textWordCount;
    private TextView textPattern;
    private Switch switchPattern;
    private EditText etSearch;
    private Button btnSearch;
    private ProgressBar progressBar1, progressBar2, progressBar3;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getDependencies().inject(this);

        initViews();
        initPresenter();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showProgressBar1() {
        progressBar1.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar1() {
        progressBar1.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar2() {
        progressBar2.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar2() {
        progressBar2.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar3() {
        progressBar3.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar3() {
        progressBar3.setVisibility(View.GONE);
    }

    @Override
    public void get10thCharSuccessfully(model10th model10th) {
        text10thChar.setText(model10th.getText());
    }

    @Override
    public void show10thCharNetworkError(String mError) {
        Toast.makeText(RunActivity.this, mError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getEvery10thCharSuccessfully(modelEvery10th modelEvery10th) {
        textEvery10thChar.setText(modelEvery10th.getListEvery10th().toString());
    }

    @Override
    public void showEvery10thCharNetworkError(String mError) {
        Toast.makeText(RunActivity.this, mError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getWordCount(modelWordCount modelWordCount) {
        textWordCount.setText(modelWordCount.getWordCount().toString());
    }

    @Override
    public void showWordCountNetworkError(String mError) {
        Toast.makeText(RunActivity.this, mError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changePatternText(String pattern) {
        textPattern.setText(pattern);
    }

    @Override
    public void updateSearchResult(String result) {
        textWordCount.setText(result);
    }

    private void initViews(){
        setContentView(R.layout.activity_run);

        text10thChar = (TextView)findViewById(R.id.text10thChar);
        textEvery10thChar = (TextView)findViewById(R.id.textEvery10thChar);
        textWordCount = (TextView)findViewById(R.id.textWordCount);

        textPattern = (TextView)findViewById(R.id.textPattern);
        switchPattern = (Switch)findViewById(R.id.switchPattern);

        etSearch = (EditText)findViewById(R.id.etSearch);
        btnSearch = (Button)findViewById(R.id.btnSearch);

        progressBar1 = (ProgressBar) findViewById(R.id.progress1);
        progressBar2 = (ProgressBar) findViewById(R.id.progress2);
        progressBar3 = (ProgressBar) findViewById(R.id.progress3);

        btnStart = (Button)findViewById(R.id.start_button);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runPresenter.makeCalls();
            }
        });

        switchPattern.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                runPresenter.UpdatePattern(!b);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runPresenter.SearchWord(etSearch.getText().toString().toLowerCase());
            }
        });
    }

    private void initPresenter(){
        runPresenter = new RunPresenter(mService, this);
    }
}
