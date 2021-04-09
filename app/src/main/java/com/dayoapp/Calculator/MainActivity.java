package com.dayoapp.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        //画面サイズを取得
        TableLayout r = (TableLayout) findViewById(R.id.tableLayout);
        Point view = DisplaySizeManager.getViewSize(r);

        OnClickActivity listener = new OnClickActivity();
        for (Button button : getButtonList()) {
            button.setOnClickListener(listener);
            button.getLayoutParams().height = (int) (view.y / 7.3);
        }
    }

    /**
     * Buttonオブジェクトを格納したリストを返す
     * @return 配置している全てのButtonオブジェクトを格納したButton型リスト
     */
    private List<Button> getButtonList() {
        List<Button> buttonList = new ArrayList<>();

        //1行目
        buttonList.add((Button) findViewById(R.id.clear));
        buttonList.add((Button) findViewById(R.id.sign));
        buttonList.add((Button) findViewById(R.id.percent));
        buttonList.add((Button) findViewById(R.id.divided));

        //2行目
        buttonList.add((Button) findViewById(R.id.bt7));
        buttonList.add((Button) findViewById(R.id.bt8));
        buttonList.add((Button) findViewById(R.id.bt9));
        buttonList.add((Button) findViewById(R.id.multiplied));

        //3行目
        buttonList.add((Button) findViewById(R.id.bt4));
        buttonList.add((Button) findViewById(R.id.bt5));
        buttonList.add((Button) findViewById(R.id.bt6));
        buttonList.add((Button) findViewById(R.id.minus));

        //4行目
        buttonList.add((Button) findViewById(R.id.bt1));
        buttonList.add((Button) findViewById(R.id.bt2));
        buttonList.add((Button) findViewById(R.id.bt3));
        buttonList.add((Button) findViewById(R.id.plus));

        //5行目
        buttonList.add((Button) findViewById(R.id.bt0)); //横長ボタン
        buttonList.add((Button) findViewById(R.id.period));
        buttonList.add((Button) findViewById(R.id.result));

        return buttonList;
    }

    @Override
    public void onBackPressed() {
    }

    /**
     * ボタンクリックイベントの詳細を記述したインナークラス
     */
    private class OnClickActivity implements View.OnClickListener {
        private BigDecimal firstValue = null;   //計算式の左項を保持する
        private String tmpValue = "";           //入力中の値を保持する
        private char calcSymbol = 0;            //四則演算の記号を保持する

        @Override
        public void onClick(View view) {
            if (view == null) return;
            TextView formula = findViewById(R.id.formura);

            //最大入力桁数を超えているかの判定
            boolean isMaxDigit = tmpValue.contains(".") ?
                    12 <= tmpValue.replace(".", "").length() : 12 <= tmpValue.length();

            switch (view.getId()) {
                //四則演算ボタンの処理(未入力の状態では無反応)
                case R.id.plus:
                    if (!tmpValue.equals("") || firstValue != null) formula.setText(preCalc('+'));
                    break;

                case R.id.minus:
                    if (!tmpValue.equals("") || firstValue != null) formula.setText(preCalc('-'));
                    break;

                case R.id.multiplied:
                    if (!tmpValue.equals("") || firstValue != null) formula.setText(preCalc('×'));
                    break;

                case R.id.divided:
                    if (!tmpValue.equals("") || firstValue != null) formula.setText(preCalc('÷'));
                    break;

                //数字ボタン、少数点の処理
                case R.id.bt0:
                    if (tmpValue.length() == 1 && tmpValue.endsWith("0") || isMaxDigit) break; //数値が0のみの場合に0だけを複数並ばせない
                    if (isReset(formula)) formula.setText("");
                    addToTextView(formula, '0');
                    tmpValue += '0';
                    break;

                case R.id.bt1:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '1');
                    tmpValue += '1';
                    break;

                case R.id.bt2:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '2');
                    tmpValue += '2';
                    break;

                case R.id.bt3:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '3');
                    tmpValue += '3';
                    break;

                case R.id.bt4:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '4');
                    tmpValue += '4';
                    break;

                case R.id.bt5:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '5');
                    tmpValue += '5';
                    break;

                case R.id.bt6:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '6');
                    tmpValue += '6';
                    break;

                case R.id.bt7:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '7');
                    tmpValue += '7';
                    break;

                case R.id.bt8:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '8');
                    tmpValue += '8';
                    break;

                case R.id.bt9:
                    if (isMaxDigit) break;
                    if (isReset(formula)) {
                        formula.setText("");
                        tmpValue = "";
                        if (calcSymbol == '=') clear();
                    }
                    addToTextView(formula, '9');
                    tmpValue += '9';
                    break;

                case R.id.period:
                    if (tmpValue.endsWith(".") || tmpValue.contains(".") || isMaxDigit) break; //.を沢山並べない処理

                    //値の未入力時は自動で 0. になる
                    if (tmpValue.equals("")) {
                        formula.setText("");
                        addToTextView(formula, '0');
                        tmpValue += '0';
                    }

                    addToTextView(formula, '.');
                    tmpValue += '.';
                    break;

                //その他機能の処理
                case R.id.result:
                    if (firstValue != null && !tmpValue.equals("")) {
                        formula.setText(preCalc('='));
                        if (formula.getText().equals("エラー")) clear(); //エラー時は保持している値をリセット
                    }
                    break;

                case R.id.clear:
                    formula.setText("");
                    clear();
                    break;

                case R.id.sign:
                    if (!tmpValue.equals("")) {
                        BigDecimal bd = new BigDecimal(tmpValue);
                        tmpValue = bd.negate().toString();
                        formula.setText(tmpValue);
                    } else if (firstValue != null) {
                        firstValue = firstValue.negate();
                        formula.setText(firstValue.toPlainString());
                    }
                    break;

                case R.id.percent:
                    if (!tmpValue.equals("")) {
                        BigDecimal result =
                                new BigDecimal(tmpValue).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP).stripTrailingZeros();
                        tmpValue = (result.compareTo(BigDecimal.ZERO) == 0) ? "0" : result.toPlainString();
                        formula.setText(tmpValue);
                    }
                    break;
            }
        }

        /**
         * TextViewの表示文字列の末尾に、受け取った文字を追加する
         *
         * @param textView     計算式のviewオブジェクト
         * @param addCharactor 入力された文字
         */
        private void addToTextView(TextView textView, char addCharactor) {
            textView.setText(textView.getText().toString() + addCharactor);
        }

        /**
         * TextViewの表示をリセットするか判定する
         * 対象：右項の最初の入力時、数列の頭が0の場合、エラー文字列を表示している時、 =押下後の場合
         *
         * @param textView 計算式のviewオブジェクト
         * @return リセットが必要：true / リセットが不要：false
         */
        private boolean isReset(TextView textView) {
            if (firstValue != null && tmpValue.equals("") || tmpValue.equals("0")
                    || textView.getText().equals("エラー") || calcSymbol == '=') return true;
            else return false;
        }

        /**
         * 保持している値、記号を初期化する
         */
        private void clear() {
            tmpValue = "";
            firstValue = null;
            calcSymbol = 0;
        }

        /**
         * 計算記号と左項の値を保持し、演算の呼び出しについての処理を行う
         *
         * @param addSymbol 入力された計算記号
         * @return 演算を行った場合：計算結果 / 演算を行わなかった場合：時点の右項の値
         */
        private String preCalc(char addSymbol) {
            //二項の値が存在する場合は計算を行う
            if (firstValue != null && !tmpValue.equals("")) {
                firstValue = calclate(new BigDecimal(tmpValue), calcSymbol);
                if (firstValue == null) return "エラー";
            }

            //初回処理 (1つ目の項の値と計算方法を保持する)
            if (firstValue == null) firstValue = new BigDecimal(tmpValue);

            tmpValue = "";
            calcSymbol = addSymbol;
            return firstValue.toPlainString();
        }

        /**
         * 受け取った計算記号に合わせた四則演算を行い、結果を返す
         *
         * @param lastValue  右項の値
         * @param calcSymbol 演算を行う計算記号
         * @return 演算結果の値 (指数表記不可)
         */
        private BigDecimal calclate(BigDecimal lastValue, char calcSymbol) {
            BigDecimal result = null;
            switch (calcSymbol) {
                case '+':
                    result = firstValue.add(lastValue);
                    break;

                case '-':
                    result = firstValue.subtract(lastValue);
                    break;

                case '×':
                    result = firstValue.multiply(lastValue);
                    break;

                case '÷':
                    try {
                        result = firstValue.divide(lastValue);
                    } catch (ArithmeticException arithmeticException) {
                        try {
                            //割り切れなかった場合は、計算結果を表示桁数に丸める
                            result = firstValue.divide(lastValue, 10, RoundingMode.HALF_UP);
                        } catch (Exception e) {
                            return null; //0割りなど、計算不可の場合
                        }
                    }
                    break;
            }

            if (result.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
            else return result.stripTrailingZeros();
        }

        /**
         * 小数点以下の0終わりを除去する (BigDecimal.stripTrailingZeros()で解決した為不使用)
         *
         * @param value 処理対象の数字文字列
         * @return 小数点以下から不要な0を除去した数字文字列
         */
        private String noZeroEnd(String value) {
            if (value.contains(".") && value.endsWith("0")) {
                char[] chAry = value.toCharArray();
                int lastIndex = -1;

                //小数点以下に 0 以外の数がある場合は、indexを取得する
                for (int i = chAry.length - 1; i > value.indexOf("."); i--) {
                    if (chAry[i] != '0') {
                        lastIndex = value.lastIndexOf(chAry[i]);
                        break;
                    }
                }

                if (lastIndex != -1) value = value.substring(0, lastIndex + 1);
                else value = value.substring(0, value.indexOf("."));
            }
            return value;
        }
    }
}