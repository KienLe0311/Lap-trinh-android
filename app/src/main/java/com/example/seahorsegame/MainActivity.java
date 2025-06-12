package com.example.seahorsegame;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int TOTAL_CELLS = 25;
    private static final int PENALTY_CELLS = 3;
    private static final int REWARD_CELLS = 3;
    private int playerPosition = 0;
    private List<Integer> penaltyCells = new ArrayList<>();
    private List<Integer> rewardCells = new ArrayList<>();
    private List<Integer> quizCells = new ArrayList<>();
    private Button[] cells;
    private Button rollDiceButton;
    private TextView positionText;
    private Random random = new Random();
    private boolean isDiceRollAction = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        rollDiceButton = findViewById(R.id.rollDiceButton);
        positionText = findViewById(R.id.positionText);

        int rows = 5;
        int cols = 5;
        cells = new Button[TOTAL_CELLS];
        int number = 1;
        float scale = getResources().getDisplayMetrics().density;
        int sizeInPx = (int) (50 * scale + 0.5f);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int actualCol;
                if (row % 2 == 0) {
                    // Hàng chẵn: cột giữ nguyên thứ tự từ trái sang phải
                    actualCol = col;
                } else {
                    // Hàng lẻ: cột đảo ngược từ phải sang trái
                    actualCol = cols - 1 - col;
                }

                Button button = new Button(this);
                button.setText(String.format("%02d", number));
                button.setTextSize(10f);

                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = sizeInPx;
                params.height = sizeInPx;
                params.rowSpec = GridLayout.spec(row);
                params.columnSpec = GridLayout.spec(actualCol);
                params.setMargins(2, 2, 4, 4);

                button.setLayoutParams(params);

                gridLayout.addView(button);
                cells[number - 1] = button;
                number++;
            }
        }

        setupBoard();
        updatePlayerPosition(0);

        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDiceRollAction = true; // Đánh dấu đây là hành động tung xúc xắc
                rollDice();
            }
        });
    }

    private void setupBoard() {
        penaltyCells.clear();
        rewardCells.clear();
        quizCells.clear();

        List<Integer> availableCells = new ArrayList<>();
        for (int i = 3; i < TOTAL_CELLS; i++) {
            availableCells.add(i);
        }
        Collections.shuffle(availableCells);

        for (int i = 0; i < PENALTY_CELLS && !availableCells.isEmpty(); i++) {
            penaltyCells.add(availableCells.remove(0));
        }

        for (int i = 0; i < REWARD_CELLS && !availableCells.isEmpty(); i++) {
            rewardCells.add(availableCells.remove(0));
        }

        for (int i = 0; i < TOTAL_CELLS; i++) {
            if (!penaltyCells.contains(i) && !rewardCells.contains(i)) {
                quizCells.add(i);
            }
        }

        for (int i = 0; i < TOTAL_CELLS; i++) {
            cells[i].setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    private void rollDice() {
        int diceResult = random.nextInt(6) + 1;
        Toast.makeText(this, "Bạn tung được: " + diceResult, Toast.LENGTH_SHORT).show();
        movePlayer(diceResult);
    }

    private void movePlayer(int steps) {
        cells[playerPosition].setText(String.valueOf(playerPosition + 1));
        cells[playerPosition].setBackgroundColor(getResources().getColor(R.color.white));

        playerPosition += steps;
        if (playerPosition >= TOTAL_CELLS) {
            playerPosition = TOTAL_CELLS - 1;
            showWinDialog();
            isDiceRollAction = false;
            return;
        } else if (playerPosition < 0) {
            playerPosition = 0;
        }
        updatePlayerPosition(playerPosition);
        if (isDiceRollAction) {
            checkCellType(playerPosition);
        }
    }

    private void updatePlayerPosition(int position) {
        positionText.setText("Vị trí: " + (position + 1));
        cells[position].setText("X");
        cells[position].setBackgroundColor(getResources().getColor(R.color.yellow_highlight));
    }

    private void checkCellType(int position) {
        if (penaltyCells.contains(position)) {
            showPenaltyDialog();
        } else if (rewardCells.contains(position)) {
            showRewardDialog();
        } else if (quizCells.contains(position)) {
            showQuizDialog();
        }
        isDiceRollAction = false;
    }

    private void showPenaltyDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Ô Hình Phạt")
                .setMessage("Bạn đã bị lùi 3 ô!")
                .setPositiveButton("OK", (dialog, which) -> movePlayer(-3))
                .setCancelable(false)
                .show();
    }

    private void showRewardDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Ô Giải Thưởng")
                .setMessage("Chúc mừng! Bạn được tiến thêm 3 ô!")
                .setPositiveButton("OK", (dialog, which) -> movePlayer(3))
                .setCancelable(false)
                .show();
    }

    private void showQuizDialog() {
        Question question = Questions.getRandomQuestion();
        String[] options = question.getOptions();

        View dialogView = getLayoutInflater().inflate(R.layout.answer, null);
        TextView questionText = dialogView.findViewById(R.id.questionText);
        Button answerButton1 = dialogView.findViewById(R.id.answerButton1);
        Button answerButton2 = dialogView.findViewById(R.id.answerButton2);
        Button answerButton3 = dialogView.findViewById(R.id.answerButton3);

        questionText.setText(question.getQuestion());
        answerButton1.setText(options[0]);
        answerButton2.setText(options[1]);
        answerButton3.setText(options[2]);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
                .create();

        answerButton1.setOnClickListener(v -> {
            checkAnswer(0, question.getCorrectAnswerIndex());
            dialog.dismiss();
        });
        answerButton2.setOnClickListener(v -> {
            checkAnswer(1, question.getCorrectAnswerIndex());
            dialog.dismiss();
        });
        answerButton3.setOnClickListener(v -> {
            checkAnswer(2, question.getCorrectAnswerIndex());
            dialog.dismiss();
        });

        dialog.show();
    }

    private void checkAnswer(int selectedIndex, int correctIndex) {
        if (selectedIndex == correctIndex) {
            Toast.makeText(this, "Đúng! Bạn được tiến 2 ô!", Toast.LENGTH_SHORT).show();
            movePlayer(2);
        } else {
            Toast.makeText(this, "Sai! Lùi 3 ô!", Toast.LENGTH_SHORT).show();
            movePlayer(-3);
        }
    }

    private void showWinDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Chúc Mừng")
                .setMessage("Bạn đã đến đích!")
                .setPositiveButton("Chơi lại", (dialog, which) -> {
                    playerPosition = 0; // Đặt lại vị trí người chơi
                    setupBoard();       // Thiết lập lại bảng
                    updatePlayerPosition(0); // Cập nhật vị trí bắt đầu
                })
                .setCancelable(false)
                .show(); // Bổ sung phương thức show() để hiển thị hộp thoại
    }

}