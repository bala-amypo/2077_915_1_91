@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category Controller", description = "Category APIs")
public class CategoryController {

    @PostMapping
    public String createCategory() {
        return "Category created";
    }

    @GetMapping
    public String listCategories() {
        return "All categories";
    }

    @GetMapping("/{id}")
    public String getCategory(@PathVariable Long id) {
        return "Category " + id;
    }
}
