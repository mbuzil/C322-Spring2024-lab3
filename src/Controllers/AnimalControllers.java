package Controllers;
@RestController
@RequestMapping("/animals")
public class AnimalControllers {
    private AnimalRepository animalRepository;

    public AnimalControllers(AnimalRespository animalRepository)
    {
        this.animalRepository = animalRepository;
    }
    @PostMapping
    public boolean add(RequestBody AnimalData data)
    {
        try{
            return animalRepository.add(Data);
        } catch (IOException e) {
            return false;
        }
    }
}
