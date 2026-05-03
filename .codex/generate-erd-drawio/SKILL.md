---
name: generate-erd-drawio
description: Convert Entity-Relationship Diagram exercises from images, PDFs, screenshots, pasted text, or Markdown into diagrams.net/drawio .drawio files using Chen ER notation. Use when Codex must read an ERD task statement or existing ERD image/PDF, infer entities, attributes, keys, relationships, cardinalities, multivalued/derived/composite attributes, or specialization/generalization, and generate a drawio file that matches the base-de-datos/03162026.md reference style.
---

# Generate ERD Drawio

## Workflow

1. Read the source exercise completely.
   - For attached images/screenshots, inspect the diagram and task text visually.
   - For PDFs, extract embedded text first when available; inspect pages/images if text extraction misses diagrams or handwriting.
   - Preserve Spanish labels from the source unless the user asks for normalization.

2. Build a compact ER model before drawing.
   - Identify each entity once.
   - List attributes under the owning entity or relationship.
   - Mark key attributes, multivalued attributes, derived attributes, and composite attribute children.
   - Represent relationships as named diamonds with participants and `1`/`N` cardinalities.
   - Represent specialization/generalization with a triangle labeled `es`.

3. Load `references/chen-reference-design.md` when deciding notation or styling.

4. Generate the diagram.
   - Use the installed drawio MCP/editor to create and edit the diagram.
   - Use the same shapes and styles from the reference: rectangles, ellipses, diamonds, plain connector lines, and separate `1`/`N` text labels.
   - If the drawio MCP tools are not exposed in the current session, stop and tell the user that the drawio MCP is unavailable instead of hand-generating a replacement file.

5. Review the `.drawio` result before finishing.
   - Check that all entities, attributes, keys, relationship names, and cardinalities from the exercise are present.
   - Check that the output uses Chen notation, not relational table notation or crow's-foot notation.
   - Refine with drawio MCP if the initial layout produces overlaps.

## Output Rules

- Save the file next to the source exercise unless the user gives a path. Use a clear suffix such as `_erd.drawio`.
- Keep labels short and faithful to the exercise.
- Use `1` and `N` cardinality labels near relationship connectors.
- Add a short note in the final response with the output path and any assumptions made while inferring missing keys or cardinalities.
