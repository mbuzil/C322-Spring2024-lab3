package repository;
@Component
public class AnimalRepository {
    private static final String NEW_LINE = System.lineSeparator();

    private static final String DATABASE_NAME = "db.txt";

    private static void appendToFile(Path path, String content) throws IOException
    {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public boolean add(AnimalData, animalData) throws IOException
    {
        Path path = Paths.get(DATABASE_NAME);
        String data = animalData.getName() + "," +
                animalData.getPicture() +
                "," + animalData.getLocation();
        appendToFile(path, data + NEW_LINE);
        return true;
    }
}
