package com.example.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearn.ui.theme.ComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLearnTheme {
              Modifier.fillMaxSize()
                SearchBar()
                AlignElement()
                FavCollection()
            }
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.primary
            ),
            placeholder = {
                Text(text = "Search")
            },

            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }
}

@Composable
fun AlignElement() {


     Column(
         modifier = Modifier,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
        Image(
            painter = painterResource(id = R.drawable.pngegg),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            text = "Punisher"
        )
    }
}

@Composable
fun FavCollection() {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.leaf),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp),
                contentDescription = null)

            Text(
                text = "Nature Meditations",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun AlignRow() {
   LazyRow(
       horizontalArrangement = Arrangement.spacedBy(8.dp),
       modifier = Modifier
   ) {
      
   }
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    ComposeLearnTheme {
       Surface (
           modifier = Modifier.fillMaxWidth()
       ){
           SearchBar()
       }
    }
}

@Preview(showBackground = true)
@Composable
private fun AlignPreview() {
    ComposeLearnTheme {
        Surface (
        ){
            AlignElement()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FavCollPrev() {
    ComposeLearnTheme {
        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
        ) {
            FavCollection()
        }
    }
}
