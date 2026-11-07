package com.example.ecommerceapp;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Filter button setup
        ImageButton btnFilter = findViewById(R.id.btnFilter);
        if (btnFilter != null) {
            btnFilter.setOnClickListener(v ->
                    Toast.makeText(MainActivity.this, "Filter option selected", Toast.LENGTH_SHORT).show()
            );
        }

        // Initialize RecyclerView with a 2-column GridLayoutManager
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        // Create sample product data
        List<Product> productList = getSampleProducts();

        // Set Adapter to populate grid
        ProductAdapter adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
    }

    private List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Wireless Noise-Cancelling Headphones", 129.99, R.drawable.ic_headphones));
        products.add(new Product("Smart Fitness Watch", 249.99, R.drawable.ic_watch));
        products.add(new Product("Lightweight Running Shoes", 89.99, R.drawable.ic_shoes));
        products.add(new Product("Flagship Smartphone 5G", 999.00, R.drawable.ic_phone));
        products.add(new Product("Waterproof Travel Backpack", 49.50, R.drawable.ic_backpack));
        products.add(new Product("Ultra Slim Laptop 15\"", 1199.99, R.drawable.ic_laptop));
        return products;
    }
}
