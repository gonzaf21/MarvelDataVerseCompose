package com.gonzalab.marveldataverse.presentation.character_list

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.gonzalab.marveldataverse.domain.model.Character

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier
) {
    // Expanded state for card.
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Row(
            Modifier
                .padding(16.dp)
        ) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.thumbnail.url())
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .width(100.dp)
                    .height(100.dp),
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .scale(0.5f)
                    )
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = character.name,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(2f)
                    )
                    // Icon arrow expanded state with rotation.
                    if (character.description.isNotBlank())
                        Icon(
                            imageVector = Icons.Rounded.ArrowDropDown,
                            contentDescription = null,
                            modifier = Modifier.rotate(rotationState)
                        )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = character.description,
                    maxLines = if (expandedState) 50 else 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
