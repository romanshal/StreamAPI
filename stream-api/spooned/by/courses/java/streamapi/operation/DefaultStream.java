package by.courses.java.streamapi.operation;


public class DefaultStream implements by.courses.java.streamapi.operation.Operation<by.courses.java.streamapi.entity.UserBase> {
    @java.lang.Override
    public java.util.Collection<by.courses.java.streamapi.entity.UserBase> removeWithMaxAge(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities) {
        return entities.stream().filter(( user) -> (user.getAge()) < (entities.stream().mapToDouble(by.courses.java.streamapi.entity.UserBase::getAge).max().orElse(java.lang.Double.MAX_VALUE))).collect(java.util.stream.Collectors.toList());
    }

    @java.lang.Override
    public java.util.Collection<by.courses.java.streamapi.entity.UserBase> removeAllOlder(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities, int age) {
        return entities.stream().filter(( user) -> (user.getAge()) <= age).collect(java.util.stream.Collectors.toList());
    }

    @java.lang.Override
    public double getAverageAge(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities) {
        return entities.stream().collect(java.util.stream.Collectors.averagingDouble(( user) -> user.getAge()));
    }

    @java.lang.Override
    public by.courses.java.streamapi.entity.UserBase getThirdInCollection(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities) {
        return entities.stream().skip(2).findFirst().get();
    }

    @java.lang.Override
    public java.util.Collection<by.courses.java.streamapi.entity.UserBase> getTwoUsersStartingFromSecond(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities) {
        return entities.stream().skip(1).limit(2).collect(java.util.stream.Collectors.toList());
    }

    @java.lang.Override
    public boolean isCharacterPresentInAllNames(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities, java.lang.String character) {
        if (entities.stream().allMatch(( user) -> user.getName().toUpperCase().contains(character.toUpperCase())))
            return true;
        else
            return false;

    }

    @java.lang.Override
    public java.util.Collection<by.courses.java.streamapi.entity.UserBase> addValueToAllNames(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities, java.lang.String value) {
        return entities.stream().map(( user) -> by.courses.java.streamapi.entity.UserBase.of(((user.getName()) + value), user.getAge())).collect(java.util.stream.Collectors.toList());
    }

    @java.lang.Override
    public java.util.Collection<by.courses.java.streamapi.entity.UserBase> sortByNameThanByAge(java.util.Collection<by.courses.java.streamapi.entity.UserBase> entities) {
        return entities.stream().sorted(java.util.Comparator.comparing(by.courses.java.streamapi.entity.UserBase::getName).thenComparing(by.courses.java.streamapi.entity.UserBase::getAge)).collect(java.util.stream.Collectors.toList());
    }
}

