# Chen ERD Reference Design

Use this notation to match `base-de-datos/03162026.md`.

## Shapes

- Entity: rectangle, no rounded corners, centered label inside.
- Attribute: ellipse connected to its entity or relationship with a plain line.
- Key attribute: ellipse with underlined label (`fontStyle=4` in drawio).
- Composite attribute: parent ellipse connected to child ellipses.
- Multivalued attribute: double ellipse and an asterisk in the label, for example `telefono*`.
- Derived attribute: dashed ellipse.
- Relationship: diamond/rhombus with the relationship name inside.
- Specialization/generalization: triangle labeled `es`, connected from supertype to subtype entities.
- Cardinality: separate text labels `1` or `N` placed beside the relevant relationship connector.

## Drawio Styles

Use these styles when creating cells directly:

```text
Entity:       rounded=0;whiteSpace=wrap;html=1;
Attribute:    ellipse;whiteSpace=wrap;html=1;fontStyle=0
Key attr:     ellipse;whiteSpace=wrap;html=1;fontStyle=4
Multivalue:   ellipse;shape=doubleEllipse;whiteSpace=wrap;html=1;
Derived:      ellipse;whiteSpace=wrap;html=1;fontStyle=0;dashed=1;dashPattern=12 12;
Relationship: rhombus;whiteSpace=wrap;html=1;
Connector:    rounded=0;orthogonalLoop=1;jettySize=auto;html=1;endArrow=none;endFill=0;
Cardinality:  text;html=1;whiteSpace=wrap;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;rounded=0;
```

## Modeling Rules

- Do not use crow's-foot endpoints for this class reference.
- Do not convert the conceptual ERD into relational tables unless the user asks for that separately.
- Keep each entity name unique in the diagram.
- Keep each relationship name unique when the exercise gives distinct relationship verbs.
- Use nouns for entities and verbs or verb phrases for relationships when the exercise leaves names implicit.
- Infer common keys conservatively (`id`, `codigo`, `numero`, `ci`, `matricula`) and mention assumptions in the final answer.
- For many-to-many relationships with attributes, keep the relationship as a diamond in the conceptual ERD.
