package com.example.jetnote.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.model.Note
import java.time.format.DateTimeFormatter

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(topEnd = 25.dp, bottomStart = 10.dp))
            .fillMaxWidth(),
        color = Color.LightGray,
        elevation = 6.dp,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = modifier
                    .padding(vertical = 6.dp, horizontal = 14.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = note.title, style = MaterialTheme.typography.subtitle2)
                Text(text = note.description, style = MaterialTheme.typography.subtitle1)
                Text(
                    text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM yyyy")),
                    style = MaterialTheme.typography.caption
                )
            }

            Box(modifier = Modifier.align(Alignment.Bottom)) {
                Icon(
                    modifier = Modifier
                        .clickable { onNoteClicked(note) }
                        .padding(12.dp),
                    imageVector = Icons.Default.Delete,
                    tint = Color.Red,
                    contentDescription = "delete Note"
                )
            }
        }
    }
}

@Preview
@Composable
fun NoteCardPreview() {
    NoteCard(note = Note(
        title = "Title",
        description = "Na description vamos colocar um texto bem grande para ver ser le não empura a lixeira para fora"
    ),
        onNoteClicked = {})
}