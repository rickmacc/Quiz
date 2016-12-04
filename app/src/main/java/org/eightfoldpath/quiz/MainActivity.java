package org.eightfoldpath.quiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.R.attr.id;
import static org.eightfoldpath.quiz.R.string.beach;

public class MainActivity extends AppCompatActivity {

    private final static String ACTIVITY_LOW = "low";
    private final static String ACTIVITY_MEDIUM = "medium";
    private final static String ACTIVITY_HIGH = "high";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scoreQuiz(View view) {
        Resources res = getResources();
        String destination = res.getString(R.string.destination_vacation);

        ImageView destinationImage = (ImageView) findViewById(R.id.image_result);

        boolean beach = isBeach();
        int budget = getBudget();
        boolean foodIncluded = isFoodIncluded();

        switch (getActivityLevel()) {
            case ACTIVITY_LOW:
                if (beach) {
                    if (budget > 5) {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_st_thomas);
                            destinationImage.setImageResource(R.drawable.st_thomas);
                        } else {
                            destination = res.getString(R.string.destination_big_sur);
                            destinationImage.setImageResource(R.drawable.big_sur);
                        }
                    } else {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_carribbean_cruise);
                            destinationImage.setImageResource(R.drawable.carribbean_cruise);
                        } else {
                            destination = res.getString(R.string.destination_orange_beach);
                            destinationImage.setImageResource(R.drawable.orange_beach);
                        }
                    }
                } else {
                     if (budget > 5) {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_european_cruise);
                            destinationImage.setImageResource(R.drawable.european_cruise);
                        } else {
                            destination = res.getString(R.string.destination_new_york);
                            destinationImage.setImageResource(R.drawable.new_york);
                        }
                    } else {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_las_vegas);
                            destinationImage.setImageResource(R.drawable.las_vegas);
                        } else {
                            destination = res.getString(R.string.destination_raleigh);
                            destinationImage.setImageResource(R.drawable.raleigh);
                        }
                    }
                }
                break;
            case ACTIVITY_MEDIUM:
                if (beach) {
                    if (budget > 5) {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_turks_and_caicos);
                            destinationImage.setImageResource(R.drawable.turks_and_caicos);
                        } else {
                            destination = res.getString(R.string.destination_cozumel);
                            destinationImage.setImageResource(R.drawable.cozumel);
                        }
                    } else {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_hawaii);
                            destinationImage.setImageResource(R.drawable.hawaii);
                        } else {
                            destination = res.getString(R.string.destination_miami);
                            destinationImage.setImageResource(R.drawable.miami);
                        }
                    }
                } else {
                    if (budget > 5) {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_alaskan_cruise);
                            destinationImage.setImageResource(R.drawable.alaskan_cruise);
                        } else {
                            destination = res.getString(R.string.destination_chicago);
                            destinationImage.setImageResource(R.drawable.chicago);
                        }
                    } else {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_las_vegas);
                            destinationImage.setImageResource(R.drawable.las_vegas);
                        } else {
                            destination = res.getString(R.string.destination_boston);
                            destinationImage.setImageResource(R.drawable.boston);
                        }
                    }
                }
                break;
            case ACTIVITY_HIGH:
                if (beach) {
                    if (budget > 5) {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_fiji);
                            destinationImage.setImageResource(R.drawable.fiji);
                        } else {
                            destination = res.getString(R.string.destination_thailand);
                            destinationImage.setImageResource(R.drawable.thailand);
                        }
                    } else {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_jamaica);
                            destinationImage.setImageResource(R.drawable.jamaica);
                        } else {
                            destination = res.getString(R.string.destination_costa_rica);
                            destinationImage.setImageResource(R.drawable.costa_rica);
                        }
                    }
                } else {
                    if (budget > 5) {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_austria);
                            destinationImage.setImageResource(R.drawable.austria);
                        } else {
                            destination = res.getString(R.string.destination_vail);
                            destinationImage.setImageResource(R.drawable.vail);
                        }
                    } else {
                        if (foodIncluded) {
                            destination = res.getString(R.string.destination_winter_park);
                            destinationImage.setImageResource(R.drawable.winter_park);
                        } else {
                            destination = res.getString(R.string.destination_lake_tahoe);
                            destinationImage.setImageResource(R.drawable.lake_tahoe);
                        }
                    }
                }
                break;
        }
        TextView quizResult = (TextView) findViewById(R.id.quiz_result);
        quizResult.setText(destination);
    }

    private boolean isBeach() {
        boolean beach = ((RadioButton) findViewById(R.id.radio_beach)).isChecked();
        Log.i("MainActivity.java", "Beach or Mountains :" + beach);
        return beach;
    }

    private int getBudget() {
        int budget = ((SeekBar) findViewById(R.id.budget)).getProgress();
        Log.i("MainActivity.java", "Budget :" + budget);
        return budget;
    }

    private boolean isFoodIncluded() {
        boolean foodIncluded = ((RadioButton) findViewById(R.id.radio_food_included_yes)).isChecked();
        Log.i("MainActivity.java", "Food Included :" + foodIncluded);
        return foodIncluded;
    }

    private String getActivityLevel() {
        String activity_level = ACTIVITY_LOW;
        boolean activity_medium = ((RadioButton) findViewById(R.id.activity_medium)).isChecked();
        if (activity_medium) activity_level = ACTIVITY_MEDIUM;
        boolean activity_high = ((RadioButton) findViewById(R.id.activity_high)).isChecked();
        if (activity_high) activity_level = ACTIVITY_HIGH;

        return activity_level;
    }

}
