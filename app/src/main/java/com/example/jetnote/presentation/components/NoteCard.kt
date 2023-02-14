package com.example.jetnote.presentation.components

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
import com.example.core.model.Note
import com.example.jetnote.presentation.utils.formatDate
import java.util.*

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onClickDelete: (Note) -> Unit,
    onClickDetails: (UUID) -> Unit
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
                    .clickable { onClickDetails(note.id) }
                    .padding(vertical = 6.dp, horizontal = 14.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = note.title, style = MaterialTheme.typography.subtitle2)
                Text(text = note.description, style = MaterialTheme.typography.subtitle1)
                Text(
                    text = formatDate(note.entryDate.time),
                    style = MaterialTheme.typography.caption
                )
            }

            Box(modifier = Modifier.align(Alignment.Bottom)) {
                Icon(
                    modifier = Modifier
                        .clickable { onClickDelete(note) }
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
        id = UUID.randomUUID(),
        title = "Title",
        description = "Na description vamos colocar um texto bem grande para ver ser le não empura a lixeira para fora"
    ),
        onClickDelete = {},
        onClickDetails = {}
    )
}