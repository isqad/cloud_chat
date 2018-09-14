package co.poputka.cloudchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;


public class MainActivity extends AppCompatActivity {

    static private final int MAX_MESSAGE_LENGHT = 150;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messages");
    EditText mEditTextMessage;
    Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSendButton = findViewById(R.id.send_button);
        mEditTextMessage = findViewById(R.id.message_input);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mEditTextMessage.getText().toString();

                if (msg.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input text", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (msg.length() > MAX_MESSAGE_LENGHT) {
                    Toast.makeText(getApplicationContext(), "Too long message", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
